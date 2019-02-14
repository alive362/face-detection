package com.cqupt.wzy.facedetection.user.service.impl;

import com.cqupt.wzy.facedetection.user.doamin.bo.UserBO;
import com.cqupt.wzy.facedetection.user.service.SessionService;

import java.util.concurrent.ConcurrentHashMap;

public class MemorySessionServiceImpl implements SessionService {
    private static final ConcurrentHashMap<String, UserBO> SESSION = new ConcurrentHashMap<String, UserBO>();

    public boolean add2Session(String innerToken, UserBO user) {
        Object object = SESSION.put(innerToken, user);
        return true;
    }

    public boolean deleteFromSession(String innerToken) {
        Object object = SESSION.remove(innerToken);
        return true;
    }

    public UserBO getFromSession(String innerToken) {
        return SESSION.get(innerToken);
    }

    @Override
    public void cleanUpSession() {
        SESSION.clear();
    }
}
