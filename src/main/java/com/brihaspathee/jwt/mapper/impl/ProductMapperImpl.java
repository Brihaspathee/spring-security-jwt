package com.brihaspathee.jwt.mapper.impl;

import com.brihaspathee.jwt.domain.entity.Product;
import com.brihaspathee.jwt.mapper.interfaces.ProductMapper;
import com.brihaspathee.jwt.web.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:29 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductDto(Product product) {
        if(product == null){
            return null;
        }
        ProductDto productDto = ProductDto.builder()
                .productId(product.getProductId())
                .productDescription(product.getProductDescription())
                .productName(product.getProductName())
                .productType(product.getProductType())
                .productPrice(product.getProductPrice())
                .build();
        return productDto;
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        if(productDto == null){
            return null;
        }
        Product product = Product.builder()
                .productId(productDto.getProductId())
                .productDescription(productDto.getProductDescription())
                .productName(productDto.getProductName())
                .productType(productDto.getProductType())
                .productPrice(productDto.getProductPrice())
                .build();
        return product;
    }

    @Override
    public List<Product> productDtosToProducts(List<ProductDto> productDtos) {
        return productDtos.stream().map(this::productDtoToProduct).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> productsToProductDtos(List<Product> products) {
        return products.stream().map(this::productToProductDto).collect(Collectors.toList());
    }
}
