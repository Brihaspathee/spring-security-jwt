package com.brihaspathee.jwt.web.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 25, May 2022
 * Time: 4:05 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private String roleName;

    private List<AuthorityDto> authorityDtos = new ArrayList<>();

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleName='" + roleName + '\'' +
                ", authorityDtos=" + authorityDtos +
                '}';
    }
}
