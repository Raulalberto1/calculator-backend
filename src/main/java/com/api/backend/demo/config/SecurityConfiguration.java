package com.api.backend.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

/*@Configuration
@EnableWebSecurity*/
public class SecurityConfiguration {

	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf ->
					csrf
						.disable()
				)
				.authorizeHttpRequests(
						auth -> {
		                    auth.requestMatchers("/operation/**", "/record/**", "/user/**").permitAll();
		                    }
				)
				.build();
	}*/
	
	/*@Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
   {
      http.authorizeHttpRequests((authz) -> authz.anyRequest().permitAll()); 
      return http.build();
   }*/
	/*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // Basic authentication for simplicity
    }*/
}
