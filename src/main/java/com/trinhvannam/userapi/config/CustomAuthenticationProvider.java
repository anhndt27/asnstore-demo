package com.trinhvannam.userapi.config;

import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.toString();
        User user = userRepository.findUserByUserName(userName);
        if (user != null) {
            String comparePassword = user.getUserPass();
            if (password == comparePassword){
                 new UsernamePasswordAuthenticationToken(userName, password,
                        Arrays.asList(new SimpleGrantedAuthority(user.getIsAdmin())));
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
