package com.brihaspathee.jwt.web.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 25, May 2022
 * Time: 4:03 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;

    private String password;

    private List<RoleDto> roleDtos = new ArrayList<>();

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleDtos=" + roleDtos +
                '}';
    }
}
