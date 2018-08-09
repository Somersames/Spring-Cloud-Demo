package com.somersames.controller;

import com.somersames.dao.ProductDao;
import com.somersames.pojo.Goods;
import com.somersames.pojo.TestPojo;
import com.somersames.util.JsonToString;
import com.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于物品的Controller
 *
 * @author szh
 * @create 2018-05-29 14:00
 **/
@RestController
@RequestMapping("goods")
@CrossOrigin
public class GoodController {

    @Autowired
    ProductDao productDao;


    @GetMapping("list/{type}")
    public ResponseResult getAllProducts(@RequestParam("type") String type){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
        // TODO 通过type判断，区分已完成和未完成以及全部显示
    }

    @GetMapping("/username/{username}")
    public ResponseResult getProductsByUserName(@RequestParam("username") String username){
        ResponseResult responseResult = new ResponseResult();
        //TODO 通过用户名查询出该人的发布历史
        return responseResult;
    }
    @GetMapping("src/main/test/angular")
    @ResponseBody
    public String testAngular(){
        TestPojo testPojo =new TestPojo();
        testPojo.setName("a");
        testPojo.setStar("一");
        List<Goods> list=productDao.queryProduct("A");
        if(list != null){
            System.out.println(list.get(0).getGoodId());
        }
        return JsonToString.JsonToString(testPojo);
    }
    @GetMapping("angular")
    @ResponseBody
    public Map<String ,Object> getMapAngular(){
        TestPojo testPojo =new TestPojo();
        testPojo.setName("a");
        testPojo.setStar("一");
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("data",testPojo);
        return map;
    }
}
