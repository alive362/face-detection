package com.cqupt.wzy.facedetection.test.controller;

import com.cqupt.wzy.facedetection.common.util.AipFaceUtil;
import com.cqupt.wzy.facedetection.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String test(){
        String image="http://ptcoopresource-1252317822.file.myqcloud.com/cooperate/operationsmanagement/51ff9287192802d2e4015a2f451f07a76c49c0ff9245bd41e35e3abc38bb46632019013111.jpg";
        String type="URL";
        HashMap<String, String> map = new HashMap<String, String>();
        String groupId="student";
        String uid="2015213992";
        System.out.println(AipFaceUtil.addUser(image,type,groupId,uid,map));
        return "ok";
    }
}
