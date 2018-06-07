package com.somersmaes.controller;

import com.somersmaes.pojo.Comment;
import com.somersmaes.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * 评论得控制类
 *
 * @author szh
 * @create 2018-05-30 17:21
 **/
@RestController
@RequestMapping("comment")
public class CommentsController {

    @GetMapping("detail/{id}")
    public ResponseResult getCommentByGoodId(@RequestParam("id") String id){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
        //TODO 获取评论消息并返回
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
