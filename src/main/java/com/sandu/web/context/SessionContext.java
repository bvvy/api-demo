package com.sandu.web.context;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
public class SessionContext {

    private static Map<String, HttpSession> sessionMap = new ConcurrentHashMap<>();

    public static void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public static HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}
