package com.somersames.controller;

import com.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * 关于物品的Controller
 *
 * @author szh
 * @create 2018-05-29 14:00
 **/
@RestController
@RequestMapping("goods")
public class GoodController {
    @GetMapping("list/{type}")
    public ResponseResult getAllProducts(@RequestParam("type") String type){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
        // TODO 通过type判断，区分已完成和未完成以及全部显示
    }

    @GetMapping("/username/{username}")
    public ResponseResult getProductsByUserName(@RequestParam("username") String username){
        ResponseResult responseResult =new ResponseResult();
        //TODO 通过用户名查询出该人的发布历史
        return responseResult;
    }

}
