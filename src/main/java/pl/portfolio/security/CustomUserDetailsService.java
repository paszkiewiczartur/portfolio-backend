package pl.portfolio.security;
 
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.portfolio.entities.User;
import pl.portfolio.entities.UserRole;
import pl.portfolio.repository.UserRepository;
 
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired 
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        org.springframework.security.core.userdetails.User userDetails = 
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(), 
                        user.getPassword(), 
                        convertAuthorities(user.getRoles()));
        return userDetails;
    }
     
    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(UserRole ur: userRoles) {
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }
}