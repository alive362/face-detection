package com.cqupt.wzy.facedetection.common.util;

import com.alibaba.fastjson.JSON;
import com.cqupt.wzy.facedetection.SpringUtil;
import com.cqupt.wzy.facedetection.user.doamin.bo.UserBO;
import com.cqupt.wzy.facedetection.user.service.SessionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class CookieUtil {
    /**
     * @param request http请求
     * @return
     */
    public static String getSessionCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("account".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static UserBO getUserBO() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("account".equals(cookie.getName())) {
                    UserBO user = SpringUtil.getBean(SessionService.class).getFromSession(cookie.getValue());
                    return user;
                }
            }
        }
        return null;
    }

    public static void initCookie(HttpServletResponse response, UserBO userBO, String key)
            throws UnsupportedEncodingException {
        // session
        Cookie cookie = new Cookie("account", key);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        // userinfo
        byte[] oldBytes = JSON.toJSONString(userBO).getBytes("utf-8");
        String old = new String(Base64.getEncoder().encode(oldBytes), "utf-8");
        Cookie cookieAllUserInfo = new Cookie("allinfo", old);
        cookieAllUserInfo.setPath("/");
        cookieAllUserInfo.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookieAllUserInfo);

    }

    public static void cleanCookie(HttpServletResponse response) throws UnsupportedEncodingException {
        // session
        Cookie cookie = new Cookie("account", StringUtils.EMPTY);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        // userinfo
        Cookie cookieAllUserInfo = new Cookie("allinfo", StringUtils.EMPTY);
        cookieAllUserInfo.setPath("/");
        cookieAllUserInfo.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookieAllUserInfo);
    }
}
