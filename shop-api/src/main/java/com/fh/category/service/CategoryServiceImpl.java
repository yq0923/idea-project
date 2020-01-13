package com.fh.category.service;

import com.alibaba.fastjson.JSONObject;
import com.fh.category.mapper.CategoryMapper;
import com.fh.category.model.Category;
import com.fh.util.RedisUtil;
import com.fh.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryList(){
        if (RedisUtil.exist(SystemConstant.KEY_CATEGORY)){
            String categoryListJson = RedisUtil.get(SystemConstant.KEY_CATEGORY);
            return JSONObject.parseArray(categoryListJson,Category.class);
        }
        List<Category> categoryList = categoryMapper.queryCategoryList();
        String jsonString = JSONObject.toJSONString(categoryList);
        RedisUtil.set(SystemConstant.KEY_CATEGORY,jsonString);
        return  categoryList;

    }


}
