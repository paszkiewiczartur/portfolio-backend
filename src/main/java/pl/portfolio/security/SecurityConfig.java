package pl.portfolio.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        //.cors().and()
        .httpBasic().and()
        .csrf()
        .disable()
//            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .authorizeRequests()
        	.antMatchers(HttpMethod.GET, "/api/books").permitAll()
            .antMatchers(HttpMethod.GET, "/api/tags").permitAll()
            .antMatchers(HttpMethod.POST, "/api/tags").permitAll()
            .antMatchers(HttpMethod.POST, "/api/guest").permitAll()
            .antMatchers(HttpMethod.POST, "/api/guests/save").permitAll()
            .antMatchers(HttpMethod.GET, "/login").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
            .antMatchers(HttpMethod.GET, "/api/getElasticBooks2").permitAll()
            .antMatchers(HttpMethod.POST, "/api/saveElasticBooks2").permitAll()
            //.antMatchers(HttpMethod.POST, "/api/comments/save").authenticated()
 //           .antMatchers(HttpMethod.GET, "/api/tags").authenticated()
//            .antMatchers(HttpMethod.GET, "/api/books/**/tags").authenticated()
//            .antMatchers(HttpMethod.POST).authenticated()
        .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }
    
/*	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}*/
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//        .withUser("john").password("pass1").roles("USER").and()
//        .withUser("lenny").password("pass2").roles("USER");
//    }
}