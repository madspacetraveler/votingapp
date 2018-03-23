package pl.grabowski_durka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.grabowski_durka.entity.User;
import pl.grabowski_durka.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcin
 */
@Service("CustomUserDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(),
                true, true, true, true,
                getGrantedAuthorities());
        }

    private List<GrantedAuthority> getGrantedAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}

