package com.zlennon.okhttp3.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


@Configuration
public class OkHttpClientConfig {

    /**
     * api	简介	生效机制
     * callTimeout()	整个流程耗费的超时时间	RealCall.execute方法，设置进入
     * AsyncTimeout + WatchDog实现
     * connectTimeout()	三次握手 + SSL建立耗时	socket.connect(address, connectTimeout)
     * readTimeout()	source读取耗时	source.timeout(readTimeout)
     * AsyncTimeout + WatchDog实现
     * rawSocket读取耗时	rawSocket.setSoTimeout(readTimeout)
     * writeTimeout()	sink写入耗时	sink.timeout(writeTimeout)
     * AsyncTimeout + WatchDog实现
     * @return
     */
    @Bean
    OkHttpClient okHttpClient(){
        OkHttpClient client = new OkHttpClient();
        return client.newBuilder()
                .callTimeout(110,TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(130,TimeUnit.SECONDS)
                .build();
    }
}
