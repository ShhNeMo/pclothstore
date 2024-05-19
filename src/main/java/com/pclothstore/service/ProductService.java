package com.pclothstore.service;

import com.pclothstore.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
//    List<ProductDTO> getFullPurchasesByUserId(Long userId);
}
