package com.brihaspathee.jwt.web.model;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:46 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {

    private List<ProductDto> productDtos;

    @Override
    public String toString() {
        return "ProductList{" +
                "productDtos=" + productDtos +
                '}';
    }
}
