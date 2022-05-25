package com.brihaspathee.jwt.mapper.interfaces;

import com.brihaspathee.jwt.domain.entity.Product;
import com.brihaspathee.jwt.web.model.ProductDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:27 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface ProductMapper {

    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
    List<Product> productDtosToProducts(List<ProductDto> productDtos);
    List<ProductDto> productsToProductDtos(List<Product> products);
}
