package com.cqupt.wzy.facedetection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.cqupt.wzy.facedetection"})
@EnableTransactionManagement(order = 5000, proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
public class FaceDetectionApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FaceDetectionApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FaceDetectionApplication.class, args);
    }

}

