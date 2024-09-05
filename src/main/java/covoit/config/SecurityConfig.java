package covoit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.Cookie; 
import ch.qos.logback.core.Context;
import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class SecurityConfig implements WebMvcConfigurer {
	@Bean
	public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
    // Créer un dépôt de contexte de sécurité pour stocker la session
    HttpSessionSecurityContextRepository repo = new HttpSessionSecurityContextRepository();
    


		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("/user/", "/user/register", "auth/login", "/**", "/swagger-ui/")
						.permitAll().requestMatchers("/user/{id}").hasRole("USER")
						.requestMatchers("/**", "/user/delete/**").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.securityContext((context -> context.securityContextRepository(repo))); // Utiliser le dépôt de contexte
				// Configurer la protection CSRF avec un cookie sécurisé (HttpOnly est activé par défaut)
				http.csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())); // Désactive HttpOnly uniquement si nécessaire

				// Utiliser requiresSecure() à la place de requiresChannel()
				http.requiresSecure(); // Forcer HTTPS

				// Ajouter des en-têtes de sécurité supplémentaires sans xssProtection()
				http.headers(headers -> headers
					.contentSecurityPolicy("default-src 'self'") // CSP pour bloquer les scripts non autorisés
					.frameOptions().deny() // Protection contre le clickjacking
					.httpStrictTransportSecurity()) // Forcer HTTPS à long terme

		//http.csrf(csrf -> csrf.disable());
		return http.build();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
				// .allowCredentials(true);
			}
		};
	}
	// Creation UserDetail temporaire
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER")
//				.build();
//		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//				.build();
//		System.out.println(user.getAuthorities());
//		return new InMemoryUserDetailsManager(user, admin);
//	}

	@Bean
	public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
		return username -> {
			UserAccount userAccount = userAccountRepository.findByUserName(username);
			if (userAccount == null) {
				throw new UsernameNotFoundException ("Utisateur ou mot de passe incorrect");
			}
			return userAccount.asUserDetails(); // Assuming `asUserDetails()` converts `UserAccount` to `UserDetails`
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
