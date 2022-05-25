package com.brihaspathee.jwt.web.resource;

import com.brihaspathee.jwt.auth.SecurityUserDetailsService;
import com.brihaspathee.jwt.domain.security.Authority;
import com.brihaspathee.jwt.domain.security.Role;
import com.brihaspathee.jwt.domain.security.User;
import com.brihaspathee.jwt.exception.AuthenticationFailedException;
import com.brihaspathee.jwt.util.JwtUtil;
import com.brihaspathee.jwt.web.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 4:07 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/security")
@RequiredArgsConstructor
public class AuthenticateResource {

    private final AuthenticationManager authenticationManager;

    private final SecurityUserDetailsService securityUserDetailsService;

    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
                            authenticateRequest.getPassword()));
        }catch (BadCredentialsException e){
            return new ResponseEntity<AuthenticateResponse>(AuthenticateResponse.builder().authMessage("Invalid Username or Password").build(), HttpStatus.UNAUTHORIZED);
            //throw new AuthenticationFailedException("Incorrect username or password");
        }

        final User userDetails = securityUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        //UserDto user = securityUserDetailsService.getUserInformation(authenticateRequest.getUsername());
        //log.info("User Information:", user);
        UserDto userDto = getUserDto(userDetails);
        return ResponseEntity.ok(AuthenticateResponse.builder()
                        .authMessage("Authentication successful")
                .jwtToken(jwt)
                        .userDto(userDto)
                .build());
    }

    @GetMapping("/authentication")
    public ResponseEntity<AuthenticateResponse> authenticate(@AuthenticationPrincipal User user){
        final String jwt = jwtUtil.generateToken(user);
        UserDto userDto = getUserDto(user);
        return ResponseEntity.ok(AuthenticateResponse.builder()
                .authMessage("Authentication successful")
                .jwtToken(jwt)
                .userDto(userDto)
                .build());
    }

    private UserDto getUserDto(User user){
        UserDto userDto = UserDto.builder()
                .username(user.getUsername())
                .roleDtos(new ArrayList<>())
                //.password(user.getPassword())
                .build();
        Set<Role> roles = user.getRoles();
        roles.stream().forEach(role -> {
            RoleDto roleDto = RoleDto.builder()
                    .roleName(role.getRoleName())
                    .authorityDtos(new ArrayList<>())
                    .build();
            Set<Authority> authorities = role.getAuthorities();
            authorities.stream().forEach(authority -> {
                AuthorityDto authorityDto = AuthorityDto.builder()
                        .permission(authority.getPermission())
                        .build();
                roleDto.getAuthorityDtos().add(authorityDto);
            });
            userDto.getRoleDtos().add(roleDto);
        });
        return userDto;
    }
}
