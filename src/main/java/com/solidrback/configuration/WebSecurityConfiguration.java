package com.solidrback.solidrback.configuration;

import com.solidrback.solidrback.security.AuthEntryPointJwt;
import com.solidrback.solidrback.security.AuthTokenFilter;
import com.solidrback.solidrback.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// The confirguration of permissions on the website
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/api/connect/**").usernameParameter("email").permitAll().and()
				.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/api/register/**").permitAll().and()
				.authorizeRequests().antMatchers("/api/login/**").permitAll()
				.antMatchers("/api/users/**").permitAll()
				.antMatchers("/api/profile/**").permitAll()
				.antMatchers("/api/strategies/**").hasRole("User")
				.antMatchers("/api/candlecollect/**").hasRole("User")
				.antMatchers("/api/informations/**").hasRole("User")
				.antMatchers("/api/tableprices/**").hasRole("User")
				.antMatchers("/api/comments/**").hasRole("User")
				.antMatchers("/api/trades/**").hasRole("Member")
				.antMatchers("/api/subscribed/**").hasRole("Member")
				.antMatchers("/api/wallets/**").hasRole("Member")
				.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
