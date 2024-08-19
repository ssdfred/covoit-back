package covoit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import covoit.repository.UserAccountRepository;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
		return username -> userAccountRepository.findByUserName(username).asUserDetails();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

		http.authorizeHttpRequests(
				request -> request.requestMatchers("/", "/login").permitAll().requestMatchers("/logout").authenticated()
						.requestMatchers("/user", "/delete/**").authenticated()
						.requestMatchers("/h2-console", "/h2-console/**").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

		return http.build();
	}
}
