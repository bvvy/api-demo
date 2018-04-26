package com.sandu.web.context;

import com.sandu.api.user.output.LoginVO;

import javax.servlet.http.HttpSession;

/**
 * @author by bvvy
 * @date 2018/4/26
 */
public class LoginContext {

    private static final String LOGIN_SESSION_NAME = "LOGIN_USER";

    public static void storageLoginInfo(HttpSession session, LoginVO loginVO) {
        session.setAttribute(LOGIN_SESSION_NAME, loginVO);
        SessionContext.addSession(session);
    }

    public static LoginVO getLoginInfo(String token) {
        HttpSession session = SessionContext.getSession(token);
        return (LoginVO) session.getAttribute(LOGIN_SESSION_NAME);
    }

    public static void removeLoginInfo(String token) {
        SessionContext.removeSession(token);
    }
}
