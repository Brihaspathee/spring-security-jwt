package com.brihaspathee.jwt.web.resource;

import com.brihaspathee.jwt.permissions.ProductCreatePermission;
import com.brihaspathee.jwt.permissions.ProductReadPermission;
import com.brihaspathee.jwt.service.interfaces.ProductService;
import com.brihaspathee.jwt.web.model.ProductDto;
import com.brihaspathee.jwt.web.model.ProductList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 24, May 2022
 * Time: 11:43 AM
 * Project: spring-security-jwt
 * Package Name: com.brihaspathee.jwt.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    @ProductReadPermission
    public ResponseEntity<ProductList> getAllProducts(){
        List<ProductDto> productDtos = productService.getAllProducts();
        ProductList productList = ProductList.builder().productDtos(productDtos).build();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{productId}")
    @ProductReadPermission
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") UUID productId){

        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);

    }

    @PostMapping
    @ProductCreatePermission
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.saveProduct(productDto);
        return new ResponseEntity<ProductDto>(savedProduct, HttpStatus.CREATED);
    }
}
