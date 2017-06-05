package com.SpringSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SpringSecurityApp.service.CustomEmployeeDetailsService;
@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	//@EnableWebSecurity
	@ComponentScan(basePackageClasses = CustomEmployeeDetailsService.class)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;

		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			/*http.authorizeRequests()
			.antMatchers("/admin-home").access("hasRole('admin')")
			.anyRequest()
			.permitAll().and()
					.formLogin().loginPage("/html/login.html")
					.usernameParameter("email")
					.passwordParameter("password").and()
					//.logout().logoutSuccessUrl("/login?logout").and()
					.exceptionHandling().accessDeniedPage("/html/403.html");//.and()
					//.csrf();
		}*/
			http
        .httpBasic()
      .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/html/admin-home.html", "/html/login.html", "/").permitAll()
          .anyRequest().authenticated();
		  //.and().csrf();
		}

		@Bean(name = "passwordEncoder")
		public PasswordEncoder passwordencoder() {
			return new BCryptPasswordEncoder();
		}
	}
