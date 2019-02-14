package com.cqupt.wzy.facedetection.common.controller;


import com.alibaba.fastjson.JSON;
import com.cqupt.wzy.facedetection.common.constant.HttpConstants;
import com.cqupt.wzy.facedetection.common.domain.vo.ResultVO;
import com.cqupt.wzy.facedetection.common.exception.ParameterException;
import com.cqupt.wzy.facedetection.common.util.*;
import com.cqupt.wzy.facedetection.user.doamin.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseStatus(value = HttpStatus.OK)
public class DefaultErrorController implements ErrorController {

    private static final String PATH = "/error";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultErrorController.class);

    /**
     * @param e 异常
     * @return json
     */
    @RequestMapping(value = {PATH})
    @ResponseBody
    public Object index(Exception e, HttpServletRequest request, HttpServletResponse response) {
        ResultVO resultVO = new ResultVO();
        Exception exception = ExceptionThreadLocalUtil.getAndRemove();
        UserBO userBO = CookieUtil.getUserBO();
        LOGGER.info(JSON.toJSONString(userBO));
        if (userBO == null) {
            resultVO = ResultVOUtil.noLogin();
            return resultVO;
        } else {
            resultVO.setCode(HttpConstants.ERROR_CODE);
            StringBuilder builder = new StringBuilder();
            builder.append(e == null ? "" : e.getLocalizedMessage());
            builder.append("__0__");
            builder.append(request.getAttribute("javax.servlet.forward.request_uri"));
            builder.append("__1__");
            builder.append(request.getAttribute("javax.servlet.forward.context_path"));
            builder.append("__2__");
            builder.append(request.getAttribute("javax.servlet.forward.servlet_path"));
            builder.append("__3__");
            builder.append(request.getAttribute("javax.servlet.forward.path_info"));
            builder.append("__4__");
            builder.append(request.getAttribute("javax.servlet.forward.query_string"));
            builder.append("__5__");
            builder.append(response.getStatus());
            builder.append("__6__");
            resultVO.setBody(builder.toString());
            handleMsg(e, response, resultVO, exception);
        }
        return resultVO;
    }

    private void handleMsg(Exception e, HttpServletResponse response, ResultVO resultVO, Exception exception) {
        if (exception != null) {
            if (exception instanceof ParameterException) {
                resultVO.setMsg(exception.getLocalizedMessage());
            }
        } else {
            switch (response.getStatus()) {
                case 404:
                    resultVO.setMsg("方法没找到");
                    break;
                case 400:
                    resultVO.setMsg("参数出错");
                    break;
            }
            LOGGER.warn("error", e);
        }
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
