package com.example.controller;

import com.example.pojo.ProductInfo;
import com.example.service.ProductInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductInfoAction {
    //
    public static final int PAGE_SIZE = 5;
    @Autowired
    private ProductInfoService productInfoService;

//    显示所有的数据不分页
    @RequestMapping("/getall")
    public String getAll(HttpServletRequest request){
        List<ProductInfo> list = productInfoService.getAll();
        request.setAttribute("list",list);
        return "product";
    }

    //显示第一页的所有数据
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        PageInfo info = productInfoService.splitPage(1, PAGE_SIZE);
        request.setAttribute("info",info);
        return "product";
    }

    //ajax分页翻页的处理
    @RequestMapping("/ajaxSplit")
    @ResponseBody
    public void ajaxSplit(int page, HttpSession session){
        //取得当前page参数页面的数据
        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info", info);
    }
}
