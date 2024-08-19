package covoit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
	        return username ->{System.out.println(username);
	       
	        UserAccount useraccount  = userAccountRepository.findByName(username);
	        System.out.println(useraccount);
	        return useraccount.asUserDetails();
	        };
	       
	        
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable());
	        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

	        http.authorizeHttpRequests(request -> request
	                .requestMatchers("/", "/login").permitAll()
	                .requestMatchers("/logout").authenticated()
	                .requestMatchers("/user", "/register").authenticated()
	                .requestMatchers("/h2-console", "/h2-console/**").hasRole("ADMIN")
	                .anyRequest().denyAll())
	                .httpBasic(Customizer.withDefaults())
	                .formLogin(Customizer.withDefaults());

	        return http.build();
	    }

 
}
