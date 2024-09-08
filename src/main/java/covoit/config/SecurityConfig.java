package covoit.config;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)  // Crée une session uniquement si nécessaire
                .maximumSessions(2)  // Limite à 2 sessions par utilisateur
                .maxSessionsPreventsLogin(true))  // Empêche les connexions supplémentaires si la limite est atteinte
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/user/", "/user/register", "auth/login", "/**", "/swagger-ui/", "/**").permitAll()  // Routes accessibles sans authentification
                .requestMatchers("/user/{id}").hasRole("USER")  // Restriction aux utilisateurs authentifiés
                //.requestMatchers("/user/delete/**", "/models/**").hasRole("ADMIN")  // Restriction aux administrateurs
                .anyRequest().authenticated())  // Toutes les autres requêtes doivent être authentifiées
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())  // Utilise un cookie pour le CSRF
                .ignoringRequestMatchers("/auth/login", "/user/register"))  // Ignore le CSRF pour certaines routes
            .httpBasic(Customizer.withDefaults());  // Utilisation de l'authentification basique HTTP

        return http.build();
    }



    @Bean
    public FilterRegistrationBean<SessionFilter> sessionFilter() {
        FilterRegistrationBean<SessionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SessionFilter());
        registrationBean.addUrlPatterns("/*");  // Applique le filtre à toutes les URLs
        return registrationBean;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Encodeur de mot de passe utilisant BCrypt
    }

    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return username -> {
            UserAccount userAccount = userAccountRepository.findByUserName(username);
            if (userAccount == null) {
                throw new BadCredentialsException("Nom d'utilisateur ou mot de passe incorrect");  // Message d'erreur plus générique
            }
            return userAccount.asUserDetails();  // Convertit l'entité UserAccount en UserDetails
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    public class SessionFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            Cookie[] allCookies = req.getCookies();

            if (allCookies != null) {
                Cookie session = Arrays.stream(allCookies)
                        .filter(x -> x.getName().equals("JSESSIONID"))
                        .findFirst()
                        .orElse(null);

                if (session != null && req.isSecure()) {  // Assure que la requête est sécurisée avant de définir le cookie comme sécurisé
                    session.setHttpOnly(true);
                    session.setSecure(true);
                    res.addCookie(session);  // Réapplique le cookie avec les attributs sécurisés
                }
            }
            chain.doFilter(req, res);  // Continue la chaîne de filtres
        }
    }
}
