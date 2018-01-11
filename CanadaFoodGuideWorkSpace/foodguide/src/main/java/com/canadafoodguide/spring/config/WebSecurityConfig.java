package com.canadafoodguide.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
          .httpBasic().and()
          .authorizeRequests()
            .antMatchers("/GetServings/Gender/**").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetServings/Category/**").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetServings/AgeGroup/**").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetServings/Category/**").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetAllDistinctAgeGroups").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetAllDailyServings").hasRole("USER"); 
        
        http
        .httpBasic().and()
        .authorizeRequests()
          .antMatchers("/GetAllFoods").hasRole("USER"); 
        
        
     }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		   BCryptPasswordEncoder encoder = passwordEncoder();
           auth
               .inMemoryAuthentication()
                   .withUser("Username").password(encoder.encode("Password")).roles("USER").and()
                   .passwordEncoder(passwordEncoder());

	} 
	
	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	

}
