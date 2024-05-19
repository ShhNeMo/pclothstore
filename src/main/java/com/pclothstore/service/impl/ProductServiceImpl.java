package com.pclothstore.service.impl;

import com.pclothstore.model.Product;
import com.pclothstore.repository.ProductRepository;
import com.pclothstore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("22222222222222");
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (product.getId() != null && !productRepository.existsById(product.getId())) {
            throw new RuntimeException("Product with ID: " + product.getId() + " not found");
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



//    @Override
//    public List<ProductDTO> getFullPurchasesByUserId(Long userId) {
//        return productRepository.findProductsByUserId(userId);
//    }
}
