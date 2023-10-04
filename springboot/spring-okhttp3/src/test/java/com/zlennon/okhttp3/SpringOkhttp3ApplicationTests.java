package com.zlennon.okhttp3;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class SpringOkhttp3ApplicationTests {

    private final String  BASE_URL="http://localhost:5006";

    @Autowired
    OkHttpClient okHttpClient;

    @Test
    void testConnectTimeOut() throws IOException {
        final Request request = new Request.Builder().url(BASE_URL + "/okhttp/readTimeout").build();
        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();

        MatcherAssert.assertThat(response.code(), equalTo(200));
    }

    @Test
    void testReadTimeOut() throws IOException {
        final Request request = new Request.Builder().url(BASE_URL + "/okhttp/readTimeout").build();
        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();

        MatcherAssert.assertThat(response.code(), equalTo(200));
    }

    @Test
    void queryByParam() throws IOException {
        final HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/okhttp/queryByParam").newBuilder();
        urlBuilder.addQueryParameter("id", "1");

        final String url = urlBuilder.build().toString();

        final Request request = new Request.Builder().url(url).build();

        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();
        String result= response.body().string();
        MatcherAssert.assertThat(result, equalTo("1"));
    }

    @Test
    void AsyncGetRequest(){
        final Request request = new Request.Builder().url(BASE_URL + "/okhttp/asyncGetRequest").build();

        final Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                log.info("response:{}",response.body().string());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                log.error("async invoke failed:{}",e);
            }
        });

    }

    @Test
    void setHeader() throws IOException {
        Request request = new Request.Builder().url(BASE_URL+"/okhttp/getHeader").addHeader("Content-Type", "application/text").build();

        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        response.close();
    }

    @Test
    void setDefaultHeader() throws IOException {

        OkHttpClient clientWithInterceptor = new OkHttpClient.Builder().addInterceptor(new DefaultContentTypeInterceptor("interceptor")).build();

        Request request = new Request.Builder().url(BASE_URL+"/okhttp/getHeader").build();

        Call call = clientWithInterceptor.newCall(request);
        Response response = call.execute();
        response.close();
    }

    @Test
    public void cancelRequest() throws IOException {
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        final Request request = new Request.Builder().url(BASE_URL + "/cancelRequest") // This URL is served with a 2 second delay.
                .build();

        final int seconds = 1;
        final long startNanos = System.nanoTime();

        final Call call = okHttpClient.newCall(request);

        // Schedule a job to cancel the call in 1 second.
        executor.schedule(() -> {

            log.info("Canceling call: " + ((System.nanoTime() - startNanos) / 1e9f));
            call.cancel();
            log.info("Canceled call: " + ((System.nanoTime() - startNanos) / 1e9f));

        }, seconds, TimeUnit.SECONDS);

        log.info("Executing call: " + ((System.nanoTime() - startNanos) / 1e9f));
        final Response response = call.execute();
        log.info("Call completed: " + ((System.nanoTime() - startNanos) / 1e9f), response);
    }

    @Test
    public void setResponseCache() throws IOException {

        final int cacheSize = 10 * 1024 * 1024; // 10 MiB
        final File cacheDirectory = new File("src/test/resources/cache");
        final Cache cache = new Cache(cacheDirectory, cacheSize);

        final OkHttpClient clientCached = new OkHttpClient.Builder().cache(cache).build();

        final Request request = new Request.Builder().url("http://publicobject.com/helloworld.txt").build();

        final Response response1 = clientCached.newCall(request).execute();
        logResponse(response1);

        final Response response2 = clientCached.newCall(request).execute();
        logResponse(response2);
    }

    private void logResponse(Response response) throws IOException {

        log.info("Response response:          " + response);
        log.info("Response cache response:    " + response.cacheResponse());
        log.info("Response network response:  " + response.networkResponse());
        log.info("Response responseBody:      " + response.body().string());
    }


    /**
     * "followRedirects" 参数通常有两个可能的值：
     * true：表示要跟随重定向。如果服务器返回重定向响应，客户端将自动向新的URL发送另一个请求。
     * false：表示不要跟随重定向。如果服务器返回重定向响应，客户端将不会自动向新的URL发送另一个请求，而会返回重定向响应本身。
     * @throws IOException
     */
    @Test
    public void setFollowRedirects() throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().followRedirects(true).build();

        Request request = new Request.Builder().url("http://t.co/I5YYd9tddw").build();

        Call call = okHttpClient.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(301));
    }


    @Test
    public void uploadFile() throws IOException {

        final RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM).
                addFormDataPart("file", "file.txt",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("src/test/resources/test.txt"))).build();

        final Request request = new Request.Builder().url(BASE_URL+"/okhttp/upload").post(requestBody).build();

        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void getUploadFileProgress() throws IOException {

        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", "file.txt",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("src/test/resources/test.txt"))).build();

        final ProgressRequestWrapper countingBody = new ProgressRequestWrapper(requestBody, (long bytesWritten, long contentLength) -> {

            final float percentage = (100f * bytesWritten) / contentLength;
            assertFalse(Float.compare(percentage, 100) > 0);
        });

        final Request request = new Request.Builder().url(BASE_URL + "/okhttp/upload").post(countingBody).build();

        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));

    }

    @Test
    public void sendPostRequest() throws IOException {
        final RequestBody formBody = new FormBody.Builder()
                .add("username", "test")
                .add("password", "test")
                .build();

        final Request request = new Request.Builder()
                .url(BASE_URL + "/okhttp/postTest")
                .post(formBody)
                .build();

        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void sendPostRequestWithAuthorization() throws IOException {
        final String postBody = "test post";
        RequestBody body = RequestBody.create(MediaType.parse("text/x-markdown;charset=utf-8"), "{\"id\":1,\"name\":\"John\"}");
        final Request request = new Request.Builder()
                .url(BASE_URL + "/okhttp/postAuth")
                .addHeader("Authorization", Credentials.basic("test", "test"))
                .post(body)
                .build();

        final Call call = okHttpClient.newCall(request);
        final Response response = call.execute();
        String charset = body.contentType().charset().displayName();

        assertThat(charset, equalTo("UTF-8"));
        assertThat(response.code(), equalTo(200));
    }






}
