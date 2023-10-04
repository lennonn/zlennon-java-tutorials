package com.zlennon.okhttp3;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public record DefaultContentTypeInterceptor(String contentType) implements Interceptor {

    @NotNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder().header("Content-Type", contentType).build();
        return chain.proceed(requestWithUserAgent);
    }
}
