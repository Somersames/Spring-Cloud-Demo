package com.somersames.controller;

import com.somersames.pojo.Goods;
import com.somersames.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * 物品的增删改查操作类
 *
 * @author szh
 * @create 2018-05-30 9:55
 **/
@RestController
@RequestMapping("goods")
public class GoodsOperation {

    @PostMapping("add")
    public ResponseResult insertNewProduct(Goods goods){
        // TODO 检查物品的一些必填项之类的，然后再检验权限
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
    }

    @DeleteMapping("delete/{goodId}")
    public ResponseResult deleteProduct(@RequestParam("goodId") Integer goodId){
        //TODO 权限校验，然后再删除
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
    }

    @PostMapping
    public ResponseResult updateProdict(){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
    }
}
