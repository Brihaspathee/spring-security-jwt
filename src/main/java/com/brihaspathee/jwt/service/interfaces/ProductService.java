package com.brihaspathee.jwt.service.interfaces;

import com.brihaspathee.jwt.web.model.ProductDto;

import java.util.List;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:24 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface ProductService {

    ProductDto getProductById(UUID productId);
    List<ProductDto> getAllProducts();
    ProductDto saveProduct(ProductDto productDto);
}
