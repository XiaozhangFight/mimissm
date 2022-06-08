package com.example.service.impl;

import com.example.mapper.ProductInfoMapper;
import com.example.pojo.ProductInfo;
import com.example.pojo.ProductInfoExample;
import com.example.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //业务逻辑层一定要有数据访问层的对象
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //使用分页工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行有条件的查询必须创建ProductInfoExample对象
        ProductInfoExample example = new ProductInfoExample();
        //设置排序按降序排序
        example.setOrderByClause("p_id desc");
        //取集合
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查询到的集合封装进pageInfo对象
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
