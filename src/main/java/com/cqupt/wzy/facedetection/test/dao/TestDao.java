package com.cqupt.wzy.facedetection.test.dao;

import com.cqupt.wzy.facedetection.test.domain.bo.TestBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<TestBO,Integer> {
}

