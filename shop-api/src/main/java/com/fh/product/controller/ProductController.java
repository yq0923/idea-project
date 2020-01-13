package com.fh.product.controller;

import com.fh.product.model.Product;
import com.fh.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("product/hot")
    public Map<String,Object> queryHotProductList(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Product> productList = productService.queryHotProductList();
            resultMap.put("code",200);
            resultMap.put("data",productList);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }


    @GetMapping("product/Brandhot")
    public Map<String,Object> queryHotBrandList(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Product> BrandList = productService.queryHotBrandList();
            resultMap.put("code",200);
            resultMap.put("data",BrandList);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","运行异常");
        }
        return resultMap;
    }

}
