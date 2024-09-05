package covoit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
	@Bean
	public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
    // Créer un dépôt de contexte de sécurité pour stocker la session
    HttpSessionSecurityContextRepository repo = new HttpSessionSecurityContextRepository();
    
	Cookie  c  =  nouveau  Cookie (repo, "XSRF-TOKEN", "csrf", "Strict-Transport-Security", "max-age=31536000 ; includeSubDomains");
		c.setSecure( true );
	c.setHttpOnly( true );

		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("/user/", "/user/register", "auth/login", "/**", "/swagger-ui/")
						.permitAll().requestMatchers("/user/{id}").hasRole("USER")
						.requestMatchers("/**", "/user/delete/**").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.securityContext((context -> context.securityContextRepository(repo))); // Utiliser le dépôt de contexte
				// Configurer la protection CSRF avec un cookie sécurisé (HttpOnly est activé par défaut)
				http.csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())); // Désactive HttpOnly uniquement si nécessaire



		return http.build();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");

			}
		};
	}


	@Bean
	public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
		return username -> {
			UserAccount userAccount = userAccountRepository.findByUserName(username);
			if (userAccount == null) {
				
			}
			return userAccount.asUserDetails(); // Assuming `asUserDetails()` converts `UserAccount` to `UserDetails`
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
