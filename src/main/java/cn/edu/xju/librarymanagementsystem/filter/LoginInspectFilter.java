package cn.edu.xju.librarymanagementsystem.filter;


import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class LoginInspectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        //log.info("请求的url:{}", url);
        
        if (url.contains("login")) {
            filterChain.doFilter(request, response);
            //log.info("登录操作，放行");
            return;
        }
        
        String jwt = request.getHeader("token");
        
        //log.info(jwt);
        if (!StringUtils.hasLength(jwt)) {
            //log.info("令牌不存在");
            Result res = Result.fail(0, "NOT_LOGIN");
            String error = JSONObject.toJSONString(res);
            response.getWriter().print(error);
            return;
        }
        try {
            JWT.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            //log.info("令牌非法");
            Result res = Result.fail(0, "NOT_LOGIN");
            String error = JSONObject.toJSONString(res);
            response.getWriter().print(error);
            return;
        }
        
        //log.info("令牌合法");
        filterChain.doFilter(request, response);
    }
}
