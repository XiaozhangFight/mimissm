package com.example.service.impl;

import com.example.mapper.ProductTypeMapper;
import com.example.pojo.ProductType;
import com.example.pojo.ProductTypeExample;
import com.example.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    //业务逻辑层一定有数据访问层的对象
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
