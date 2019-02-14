package com.cqupt.wzy.facedetection.common.exception.resolver;

import com.cqupt.wzy.facedetection.common.exception.ParameterException;
import com.cqupt.wzy.facedetection.common.util.ExceptionThreadLocalUtil;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@Component
public class AppExceptionResolver extends DefaultHandlerExceptionResolver {
    public AppExceptionResolver() {
        setOrder(-10);
    }

    @Override
    protected ModelAndView handleTypeMismatch(TypeMismatchException ex, HttpServletRequest request,
                                              HttpServletResponse response, Object handler) throws IOException {
        ExceptionThreadLocalUtil.set(new ParameterException(
                String.format("%s,%s", URLDecoder.decode(request.getRequestURI(), "utf-8"), ex.getLocalizedMessage()))
                .setRequestPath(request.getRequestURL().toString()));
        return super.handleTypeMismatch(ex, request, response, handler);
    }

}
