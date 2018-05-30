package com.somersames.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求的过滤器
 *
 * @author szh
 * @create 2018-05-30 15:37
 **/
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        return null;
        RequestContext requestContext =RequestContext.getCurrentContext();
        HttpServletRequest request =requestContext.getRequest();
        //TODO 判断是否含有验证jwt，没有就返回401标识，然后前端检测这个code，如果检查失败，就直接window.location跳转
        String token =request.getHeader("Authorization");
        System.out.println("进入Zuul");
        //TODO JWT反解密验证
        if(token == null ){
            HttpServletResponse response =requestContext.getResponse();
            response.setStatus(401);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            requestContext.setSendZuulResponse(false);
            try{
                response.getWriter().write("验证失败");
                return null;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
