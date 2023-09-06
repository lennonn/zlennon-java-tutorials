package com.zlennon.chatgptmodelservice.config;

import com.zlennon.chatgptmodelservice.filter.I18nFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LocaleConfig {
/*    @Bean
    public FilterRegistrationBean<I18nFilter> myFilter() {
        FilterRegistrationBean<I18nFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new I18nFilter());
        registrationBean.addUrlPatterns("/*"); // Set the URL patterns to which the filter should be applied
        registrationBean.setOrder(Integer.MAX_VALUE); // Set the execution order of the filter
        return registrationBean;
    }*/
}
