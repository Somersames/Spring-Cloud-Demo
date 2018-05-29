package com.somersames.controller;

import com.somersames.pojo.User;
import com.somersames.util.ResponseResult;
import com.somersames.util.StringUtil;
import org.springframework.web.bind.annotation.*;

/**
 * 用户的控制类
 *
 * @author szh
 * @create 2018-05-23 14:59
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("login")
    public ResponseResult userLogin(@RequestParam("userName") String userName,
                                    @RequestParam("password") String password,
                                    @RequestParam("timestamp") String timestamp
                                    )
    {
        ResponseResult responseResult =new ResponseResult();
        if(!StringUtil.isNotNull(userName) || !StringUtil.isNotNull(password)){
            responseResult.setParamter("errorMsg","用户名或密码不能为空");
            responseResult.setCode(400);
            return responseResult;
        }
        //TODO 查询数据库，shiro权限配置,插入log表，记录用户的登录
        return responseResult;
    }
    @PostMapping("reister")
    public ResponseResult userRegister(User user){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
    }
    @PostMapping
    public ResponseResult userChangePassword(String userName ,String password){
        ResponseResult responseResult =new ResponseResult();
        return responseResult;
    }
}
