package com.lzf.shirojwt.fliter;

import com.lzf.shirojwt.model.BaseResponse;
import com.lzf.shirojwt.model.JwtToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public class JwtFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("authorization");
        JwtToken jwtToken = new JwtToken(token);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(jwtToken);
            return true;
        }catch (AuthenticationException e){
            return false;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(new BaseResponse<String>(403,"无效token").toString());
        return false;
    }
}
