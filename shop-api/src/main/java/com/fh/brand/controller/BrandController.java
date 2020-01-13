package com.fh.brand.controller;

import com.fh.brand.model.Brand;
import com.fh.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("brand/hot")
    public Map<String,Object> queryHotBrandList(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Brand> brandList = brandService.queryHotBrandList();
            resultMap.put("code",200);
            resultMap.put("data",brandList);
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
