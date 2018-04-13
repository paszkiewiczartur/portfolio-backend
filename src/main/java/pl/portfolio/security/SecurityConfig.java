package pl.portfolio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		.httpBasic().and()
        .csrf()
//        .disable()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .authorizeRequests()
        	.antMatchers("/api/setBooksOrder").authenticated()
        	.antMatchers("/api/comments/delete/**").authenticated()
        	.antMatchers("/api/setCoursesOrder").authenticated()
        	.antMatchers("/api/setProjectsOrder").authenticated()
        	.antMatchers(HttpMethod.POST, "/api/tags/saveRelation").authenticated()
        	.antMatchers(HttpMethod.POST, "/api/tags/deleteRelation").authenticated()
        	.antMatchers(HttpMethod.POST, "/api/postFile").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/getallfiles").authenticated()
        	.antMatchers(HttpMethod.GET, "/files/**").permitAll()        	
        	.antMatchers(HttpMethod.POST, "/login").permitAll()        	
        	.antMatchers(HttpMethod.POST, "/api/guests/save").permitAll()        	
        	
        	.antMatchers(HttpMethod.GET, "/api/books").permitAll()
        	.antMatchers("/api/books").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/comments").permitAll()
        	.antMatchers("/api/comments").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/courses").permitAll()
        	.antMatchers("/api/courses").authenticated()        	
          	.antMatchers("/api/entrances").authenticated()
        	.antMatchers("/api/guests").authenticated()
          	.antMatchers(HttpMethod.POST, "/api/linkEntrances").permitAll()
          	.antMatchers("/api/ipAddresses").authenticated()
          	.antMatchers("/api/linkEntrances").authenticated()
           	.antMatchers(HttpMethod.GET, "/api/links").permitAll()
        	.antMatchers("/api/links").authenticated()
        	.antMatchers("/api/messages").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/projects").permitAll()
        	.antMatchers("/api/projects").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/siteContent").permitAll()
        	.antMatchers("/api/siteContent").authenticated()
        	.antMatchers(HttpMethod.GET, "/api/tags").permitAll()
        	.antMatchers("/api/tags").authenticated()
        	.antMatchers("/api/visitErrors").authenticated()
        	.antMatchers("/**").permitAll()
        .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }
}