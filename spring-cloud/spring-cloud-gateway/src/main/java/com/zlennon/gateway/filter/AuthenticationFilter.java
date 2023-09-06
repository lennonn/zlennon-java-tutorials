package com.zlennon.gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

public interface AuthenticationFilter extends GlobalFilter, Ordered {
}
