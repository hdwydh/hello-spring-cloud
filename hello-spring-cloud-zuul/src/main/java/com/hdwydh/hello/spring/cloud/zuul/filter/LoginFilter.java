package com.hdwydh.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // pre 路由之前
        //routing 路由之时
        //post 路由之后
        //error 发生错误时
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤的顺序,最小最靠前
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //过滤器的具体业务代码
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //ba la ba la ba la
        if (StringUtils.isBlank(token)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
