package com.ormva_tf.sec;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private javax.sql.DataSource dataSource ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("1234")).roles("USER","ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("1234")).roles("USER");
		
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
		
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("1234").roles("USER","ADMIN");
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("1234").roles("USER");

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery
		("select cin as principal, password as credentials ,'true' as enabled  from compte where cin=?  ")
		.authoritiesByUsernameQuery("select cin as principal, role as role from roles_compte where cin = ?")
		.passwordEncoder(new MessageDigestPasswordEncoder("MD5")).rolePrefix("ROLE_");
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin() ;
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/user/*").hasRole("user");
		http.authorizeRequests().antMatchers("/*").hasRole("admin");
		http.logout().deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true) ;

	
	}
}
