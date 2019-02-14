package com.cqupt.wzy.facedetection.user.service;

import com.cqupt.wzy.facedetection.user.doamin.bo.UserBO;

/**
 * session管理
 */
public interface SessionService {

    boolean add2Session(String innerToken, UserBO user);

    boolean deleteFromSession(String innerToken);

    UserBO getFromSession(String innerToken);

    void cleanUpSession();
}
