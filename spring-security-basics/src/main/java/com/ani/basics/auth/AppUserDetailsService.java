package com.ani.basics.auth;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var ud = new AppUserDetails(
                repository.findByUserName(username)
                        .orElseThrow(this::throwIfUserNotAvailable)
        );
        System.out.println("----------->");
        ud.getAuthorities().forEach(System.out::println);
        return ud;
    }

    private UsernameNotFoundException throwIfUserNotAvailable() {
        return new UsernameNotFoundException("User Not Available");
    }
}
