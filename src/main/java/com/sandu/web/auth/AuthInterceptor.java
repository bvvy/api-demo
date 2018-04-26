package com.sandu.web.auth;

import com.sandu.api.user.output.LoginVO;
import com.sandu.common.ReturnData;
import com.sandu.constant.ResponseEnum;
import com.sandu.util.Commoner;
import com.sandu.util.JsonParser;
import com.sandu.web.context.LoginContext;
import com.sandu.web.context.SessionContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(token)) {
            response.getWriter().write(JsonParser.toJson(ReturnData.builder().code(ResponseEnum.UNAUTHORIZED).message("UNAUTH")));
            return false;
        }
        HttpSession session = SessionContext.getSession(token);
        if (Commoner.isEmpty(session)) {
            response.getWriter().write(JsonParser.toJson(ReturnData.builder().code(ResponseEnum.UNAUTHORIZED).message("UNAUTH")));
            return false;
        }
        LoginVO loginVO = LoginContext.getLoginInfo(token);
        HandlerMethod method = (HandlerMethod) handler;
        Permission permission = method.getMethodAnnotation(Permission.class);
        String permit = permission.value();
        if (loginVO.getAuth().contains(permit)) {
            return true;
        }
        response.getWriter().write(JsonParser.toJson(ReturnData.builder().code(ResponseEnum.UNAUTHORIZED).message("UNAUTH")));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
