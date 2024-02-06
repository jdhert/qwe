package com.kitri.springbasicboot.lesson.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그 메시지 : init() 호출됨");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("로그 메시지 : doFilter() 호출됨");
        filterChain.doFilter(servletRequest,servletResponse); // 공통작업 설정도 가능
    }

    @Override
    public void destroy() {
        log.info("로그 메시지 : destroy() 호출됨");
    }
}
