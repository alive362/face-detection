package com.cqupt.wzy.facedetection.test.service;

import com.cqupt.wzy.facedetection.test.dao.TestDao;
import com.cqupt.wzy.facedetection.test.domain.bo.TestBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private TestDao testDao;

    public int add(TestBO bo){
        int rs=-1;
        try {
            testDao.saveAndFlush(bo);
            rs=1;
        }catch (Exception e){
            LOGGER.warn("TestService.add:"+e);
        }
        return  rs;
    }
}
