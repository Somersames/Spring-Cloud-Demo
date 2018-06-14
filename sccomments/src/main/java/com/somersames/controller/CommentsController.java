package com.somersames.controller;

import com.somersames.dao.CommentDao;
import com.somersames.pojo.Comment;
import com.somersames.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 评论得控制类
 *
 * @author szh
 * @create 2018-05-30 17:21
 **/
@RestController
@RequestMapping("comment")
public class CommentsController {

    @Autowired
    CommentDao commentDao;
    @GetMapping("detail/{product_id}")
    public ResponseResult getCommentByGoodId(@PathVariable("product_id") String product_id){
        ResponseResult responseResult =new ResponseResult();
        List<Map<Object, Object>> list =commentDao.queryCommentsByGoodId(product_id);
        responseResult.setParamter("data",list);
        return responseResult;
    }

    @PostMapping("submit")
    public ResponseResult insertNewComment(Comment comment){
        ResponseResult responseResult =new ResponseResult();
        return  responseResult ;
        //TODO 对某一个发布的物品提交新的评论
    }

    @PostMapping("delete/{commentId}")
    public ResponseResult deleteComment(@RequestParam("commentId") String commentId){
        ResponseResult responseResult =new ResponseResult();
        //TODO 删除的时候进行权限校验
        return  responseResult;
    }
}
