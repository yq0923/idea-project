package com.fh.brand.service;

import com.fh.brand.mapper.BrandMapper;
import com.fh.brand.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> queryHotBrandList() {
        return brandMapper.queryHotBrandList();
    }
}
