package com.fh.product.service;

import com.fh.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> queryHotProductList();

    Product getProductById(Integer productId);

    List<Product> queryHotBrandList();

    Long updateProductStock(Integer productId, Long count);
}
