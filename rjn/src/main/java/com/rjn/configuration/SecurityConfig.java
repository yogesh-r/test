package com.rjn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rjn.security.CustomUserDetailsService;
import com.rjn.utils.Constant;

@Configuration
@EnableWebSecurity
@ComponentScan("com.rjn")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); 	
		web.ignoring().antMatchers("/"); 
		web.ignoring().antMatchers("/why-us");
		web.ignoring().antMatchers("/how-it-work");
		web.ignoring().antMatchers("/contact-us");
		web.ignoring().antMatchers("/member/register");
		web.ignoring().antMatchers("/member/register/success");
		web.ignoring().antMatchers("/about-us");
		web.ignoring().antMatchers("/carrers");
		web.ignoring().antMatchers("/privacy-policy");
		web.ignoring().antMatchers("/member-policy");
		web.ignoring().antMatchers("/terms-and-conditions");
		web.ignoring().antMatchers("/space-provide-policy");
		web.ignoring().antMatchers("/faq");
		web.ignoring().antMatchers("/live-chat");
		web.ignoring().antMatchers("/suggestion");
		web.ignoring().antMatchers("/list-your-shop");
		web.ignoring().antMatchers("/search");
		web.ignoring().antMatchers("/vendor-profile/**");
		web.ignoring().antMatchers("/public/**");
		web.ignoring().antMatchers("/forgetPassword/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/admin/**").hasRole(Constant.ADMIN)
			.antMatchers("/admin/**/").hasRole(Constant.ADMIN)
			.antMatchers("/vendor/**").hasRole(Constant.PARTNER)
			.antMatchers("/member/**").hasRole(Constant.MEMBER)
				.anyRequest().authenticated()
				.and()
				
				.formLogin()
					.loginPage("/login")
/*					.loginProcessingUrl("/j_spring_security_check")
					.usernameParameter("j_username")
					.passwordParameter("j_password")*/
					.permitAll().successHandler(new MYSuccessHandler())
				
				.and()
				.exceptionHandling().accessDeniedPage("/accessdenied");
	}
}
