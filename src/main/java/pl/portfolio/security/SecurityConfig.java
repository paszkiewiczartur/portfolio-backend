package pl.portfolio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic().and()
        .csrf().disable()
//            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .authorizeRequests()
  //      	.anyRequest().authenticated()
        	.antMatchers(HttpMethod.GET, "/login").permitAll()
        	.antMatchers(HttpMethod.POST, "/login").permitAll()
        	.antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/search").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/getTags").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/getProjects").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/getCourses").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/getBooks").permitAll()
        	.antMatchers(HttpMethod.POST, "/api/comments/save").permitAll()
        	.antMatchers(HttpMethod.POST, "/api/messages/save").permitAll()
        	.antMatchers(HttpMethod.POST, "/api/guests/save").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/links").permitAll()
           	.antMatchers(HttpMethod.GET, "/api/siteContent").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/tags").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/projects").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/books").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/courses").permitAll()
        	.antMatchers(HttpMethod.GET, "/api/comments").permitAll()
           	.antMatchers(HttpMethod.POST, "/api/linkEntrances").permitAll()
        .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }
}