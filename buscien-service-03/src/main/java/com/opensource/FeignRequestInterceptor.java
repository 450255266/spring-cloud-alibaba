package com.opensource;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign传递请求头
 *
 * @author WuWenTao
 * @version 1.0
 * @date 2020/9/2 17:12
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    private Logger log = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        //获取请求头
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                //将请求头保存到模板中
                template.header(name, values);

            }
            //如需传递各位如token
            // template.header("token", token);
            log.info("feign interceptor header:{}", template);
        }
    }
}
