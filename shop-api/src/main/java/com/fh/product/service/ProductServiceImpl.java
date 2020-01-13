package com.fh.product.service;

import com.fh.product.mapper.ProductMapper;
import com.fh.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryHotProductList() {
        return  productMapper.queryHotProductList();

    }

    @Override
    public Product getProductById(Integer productId) {
        return productMapper.getProductById(productId);
    }

    @Override
    public List<Product> queryHotBrandList() {
        return productMapper.queryHotBrandList();
    }

    @Override
    public Long updateProductStock(Integer productId, Long count) {
        return productMapper.updateProductStock(productId,count);
    }
}
