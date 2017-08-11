package com.SpringSecurityApp.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import com.SpringSecurityApp.service.CustomEmployeeDetailsService;
@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	@EnableWebSecurity
	@ComponentScan(basePackageClasses = CustomEmployeeDetailsService.class)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;

		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
		}
		
		
		@Bean
	    public AuthenticationEntryPoint authenticationEntryPoint() {
	        return new AuthenticationEntryPoint() {
				@Override
				public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException, ServletException {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Wrong username/password");
				}
			};
	    }
		
		@Bean
	    public AccessDeniedHandler accessDeniedHandler() {
	        return new AccessDeniedHandler() {
				@Override
				public void handle(HttpServletRequest request, HttpServletResponse response,
						AccessDeniedException accessDeniedException) throws IOException, ServletException {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
					//System.out.println("into access denied handler");
					//response.sendRedirect("html/403.html");
					
				}
			};
	    }


		@Override
		protected void configure(HttpSecurity http) throws Exception {
			/*http
			.formLogin().loginPage("/index.html")
			.usernameParameter("email")
			.passwordParameter("password").and()
			//
			.and()
			.authorizeRequests()
			.antMatchers("/html/admin-home.html").access("hasRole('admin')")
			.anyRequest()//.authenticated();
			.permitAll();//.and()
					//.csrf();
		}*/
			
			http
        .httpBasic()
			//.formLogin().loginProcessingUrl("/index.html").loginPage("/index.html").defaultSuccessUrl("/html/403.html")//.registerDefaultAuthenticationEntryPoint(authenticationEntryPoint())
        .authenticationEntryPoint(authenticationEntryPoint())
			.and()
		.logout().logoutSuccessUrl("/index.html").and()
			.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler(accessDeniedHandler())
			//.accessDeniedPage("/403")
      .and()
        .authorizeRequests()
		.antMatchers("/getEmp/*")
		//.hasRole("admin")
		.access("hasAuthority('admin')")
          //.antMatchers("/html/403.html").permitAll()
          .anyRequest().permitAll();
		  //.and().csrf();
		}

		@Bean(name = "passwordEncoder")
		public PasswordEncoder passwordencoder() {
			return new BCryptPasswordEncoder();
		}
	}
