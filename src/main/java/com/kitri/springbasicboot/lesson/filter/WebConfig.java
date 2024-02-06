package com.kitri.springbasicboot.lesson.filter;

import com.kitri.springbasicboot.lesson.interceptor.LogInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(2);
        return  filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean log2Filter(){ // 다중으로 필터를 여러개 걸 수 있음
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new Log2Filter());
        filterFilterRegistrationBean.setOrder(1);
        return  filterFilterRegistrationBean;
    }
}
