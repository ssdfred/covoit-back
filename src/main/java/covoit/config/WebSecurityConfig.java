package covoit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Permettre l'accès sans authentification aux routes de création et de connexion des utilisateurs
                .antMatchers("/api/user/register", "/api/user/login").permitAll()
                // Toutes les autres routes nécessitent une authentification
                .anyRequest().authenticated()
                .and()
            .formLogin() // Utilise le formulaire de connexion par défaut de Spring Security
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable(); // Désactive la protection CSRF pour simplifier les appels d'API REST

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Crée un utilisateur en mémoire pour les tests
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}
