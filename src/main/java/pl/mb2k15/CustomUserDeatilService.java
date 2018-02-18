package pl.mb2k15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 2015-10-04.
 */
@Component
public class CustomUserDeatilService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userRepository.findByUsrName(username);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+username+" not found");
        }
        return  new SecurityDetails(user);


    }



}
