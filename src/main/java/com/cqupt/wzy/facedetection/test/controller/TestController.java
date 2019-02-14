package com.cqupt.wzy.facedetection.test.controller;

import com.cqupt.wzy.facedetection.test.domain.bo.TestBO;
import com.cqupt.wzy.facedetection.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public Integer test(){
        TestBO bo = new TestBO();
        bo.setName("wzy");
        bo.setPassword("123");
        return testService.add(bo);
    }
}
