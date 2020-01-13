package com.fh.category.controller;

import com.fh.category.model.Category;
import com.fh.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Map<String,Object> queryCategoryList(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Category> categoryList = categoryService.queryCategoryList();
            resultMap.put("code",200);
            resultMap.put("data",categoryList);
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
