package com.cqupt.wzy.facedetection.common.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResultVO<T> {
    private int code;

    private String msg;

    private boolean ifLogin = true;

    private T body;
}
