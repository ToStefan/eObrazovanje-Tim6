package eobrazovanje.tim6.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import eobrazovanje.tim6.app.repository.UserRepository;
import eobrazovanje.tim6.app.security.CustomUserDetailsService;
import eobrazovanje.tim6.app.security.JwtAuthenticationEntryPoint;
import eobrazovanje.tim6.app.security.JwtAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true,
							jsr250Enabled = true,
							securedEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
	    return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .cors()
            .and()
        .csrf()
            .disable()
        .exceptionHandling()
            .authenticationEntryPoint(unauthorizedHandler)
            .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
         .authorizeRequests()
				.antMatchers("/").permitAll();
				//.antMatchers("/swagger-ui.html#/**").permitAll()
				//.anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
}















