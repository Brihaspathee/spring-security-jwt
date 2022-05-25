package com.brihaspathee.jwt.service.impl;

import com.brihaspathee.jwt.domain.entity.Product;
import com.brihaspathee.jwt.domain.repository.ProductRepository;
import com.brihaspathee.jwt.mapper.interfaces.ProductMapper;
import com.brihaspathee.jwt.service.interfaces.ProductService;
import com.brihaspathee.jwt.web.model.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:26 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductById(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.productsToProductDtos(products);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        product = productRepository.save(product);
        return productMapper.productToProductDto(product);
    }
}
