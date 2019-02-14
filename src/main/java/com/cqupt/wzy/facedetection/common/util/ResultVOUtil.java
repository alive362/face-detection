package com.cqupt.wzy.facedetection.common.util;

import com.cqupt.wzy.facedetection.common.constant.HttpConstants;
import com.cqupt.wzy.facedetection.common.domain.vo.ResultVO;
import com.cqupt.wzy.facedetection.user.doamin.bo.RedirectBO;

public class ResultVOUtil {
    public static ResultVO noLogin() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpConstants.NO_LOGIN_CODE);
        resultVO.setIfLogin(false);
        resultVO.setMsg("未登录");
        RedirectBO redirectBO = new RedirectBO();
        //redirectBO.setRedirectUrl(SSOConfig.getLoginUrl());
        resultVO.setBody(redirectBO);
        return resultVO;
    }

    public static ResultVO logout() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpConstants.NO_LOGIN_CODE);
        resultVO.setIfLogin(false);
        resultVO.setMsg("退出");
        RedirectBO redirectBO = new RedirectBO();
       //redirectBO.setRedirectUrl(SSOConfig.getLogoutUrl());
        resultVO.setBody(redirectBO);
        return resultVO;
    }

    public static ResultVO noPrivilege() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpConstants.NO_PRIVILEGE_CODE);
        resultVO.setIfLogin(true);
        resultVO.setMsg("没改项目的操作权限");
        return resultVO;
    }
}
