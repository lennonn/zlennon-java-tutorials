package com.zlennon.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**

 */
@Component
@ConfigurationProperties("secure.iplist")
@RefreshScope
@Data
public class IPListConfig {

	/**
     * Ip白名单
	 */
	private List<String> writeList = new ArrayList<>();

	private List<String> blackList = new ArrayList<>();

	/**
	 * 加解密放行API集合
	 */
	private final List<String> skipUrl = new ArrayList<>();

	/**
	 * 幂等校验放行API集合
	 */
	private final List<String> idempotentSkipUrl = new ArrayList<>();

}
