package com.brihaspathee.jwt.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 25, May 2022
 * Time: 4:31 PM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.exception
 * To change this template use File | Settings | File and Code Template
 */
public class AuthenticationFailedException extends RuntimeException{

    public AuthenticationFailedException(String message){
        super(message);
    }

    public AuthenticationFailedException(String message, Throwable cause){
        super(message, cause);
    }
}
