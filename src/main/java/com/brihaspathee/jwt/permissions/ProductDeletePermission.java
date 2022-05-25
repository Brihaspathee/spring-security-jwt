package com.brihaspathee.jwt.permissions;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:57 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.permissions
 * To change this template use File | Settings | File and Code Template
 */
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('product.delete')")
public @interface ProductDeletePermission {
}
