package com.brihaspathee.jwt.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 25, May 2022
 * Time: 4:04 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDto {

    private String permission;

    @Override
    public String toString() {
        return "AuthorityDto{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
