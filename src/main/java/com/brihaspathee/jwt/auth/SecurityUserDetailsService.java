package com.brihaspathee.jwt.auth;

import com.brihaspathee.jwt.domain.repository.UserRepository;
import com.brihaspathee.jwt.domain.security.Authority;
import com.brihaspathee.jwt.domain.security.Role;
import com.brihaspathee.jwt.domain.security.User;
import com.brihaspathee.jwt.web.model.AuthorityDto;
import com.brihaspathee.jwt.web.model.RoleDto;
import com.brihaspathee.jwt.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 12:15 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.auth
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Getting Details from DB using JPA");
        return userRepository.findUserByUsername(username).orElseThrow( () -> {
            return new UsernameNotFoundException("User with username " + username + " not found");
        }) ;
    }
}
