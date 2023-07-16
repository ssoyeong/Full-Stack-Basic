package com.example.guestbook.argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {

    // 인자의 정보를 parameter로 전달함. 해당 파라미터 정보에 원하는 정보가 있다면 true 리턴
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == HeaderInfo.class;
    }

    // supportsParameter()가 true를 리턴할 때만, resolveArgument()가 호출됨
    // 리턴한 값은 컨트롤러의 인자로 전달됨
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HeaderInfo headerInfo = new HeaderInfo();

        Iterator<String> headerNames = webRequest.getHeaderNames();
        while(headerNames.hasNext()) {
            String headerName = headerNames.next();
            String headerValue = webRequest.getHeader(headerName);
            System.out.println(headerName + ", " + headerValue);
            headerInfo.put(headerName, headerValue);
        }

        return headerInfo;
    }
}
