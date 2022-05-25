package com.brihaspathee.jwt.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 4:07 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateRequest {

    private String username;

    private String password;

    @Override
    public String toString() {
        return "AuthenticateRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
