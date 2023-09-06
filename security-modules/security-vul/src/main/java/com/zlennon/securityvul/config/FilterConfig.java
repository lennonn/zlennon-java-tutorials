package com.zlennon.securityvul.config;

import com.zlennon.securityvul.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<SecurityFilter> myFilter() {
        FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SecurityFilter());
        registrationBean.addUrlPatterns("/*"); // Set the URL patterns to which the filter should be applied
        registrationBean.setOrder(1); // Set the execution order of the filter
        return registrationBean;
    }
}
