package com.brihaspathee.jwt.web.model;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 4:08 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class AuthenticateResponse {

    private final String authMessage;

    private final String jwtToken;

    private final UserDto userDto;

    @Override
    public String toString() {
        return "AuthenticateResponse{" +
                "authMessage='" + authMessage + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}
