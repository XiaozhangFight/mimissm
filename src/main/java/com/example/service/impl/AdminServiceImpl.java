package com.example.service.impl;

import com.example.mapper.AdminMapper;
import com.example.pojo.Admin;
import com.example.pojo.AdminExample;
import com.example.service.AdminService;
import com.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        //根据传入的用户名到数据库中查询相应用户对象
        AdminExample example = new AdminExample();
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() > 0){
            Admin admin = list.get(0);
            //将接收到的密码转换成密文再与数据库中的密码进行对比
            String mipwd = MD5Util.getMD5(pwd);
            if (mipwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
