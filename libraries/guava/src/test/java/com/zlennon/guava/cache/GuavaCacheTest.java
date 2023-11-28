package com.zlennon.guava.cache;

import com.google.common.cache.*;
import com.zlennon.guava.LoggingForwardingCache;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class GuavaCacheTest {

    CacheLoader getCacheLoader(){
       return  CacheLoader.from(key->key.toString().toUpperCase());
    }
    @Test
    public void useLoadingCache() {
        CacheLoader<String, String> loader;
        loader = getCacheLoader();

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().build(loader);

        assertEquals(0, cache.size());
        assertEquals("HELLO", cache.getUnchecked("hello"));
        assertEquals(1, cache.size());

    }




    @Test
    public void setCacheMaximumSize() {
        CacheLoader<String, String> loader;
        loader = getCacheLoader();
        LoadingCache<String, String> cache;
        //使用CacheBuilderSpec
        cache= CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=3")).build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("forth");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("FORTH", cache.getIfPresent("forth"));
    }


    @Test
    public void setCacheMaxWeight() {
        CacheLoader<String, String> loader;
        loader = getCacheLoader();
        Weigher<String, String> weighByLength;
        weighByLength = (key, value) -> value.length();

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumWeight(16)
                .weigher(weighByLength)
                .build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("LAST", cache.getIfPresent("last"));
    }

    @Test
    public void expireAfterTime()
            throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = getCacheLoader();

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.MILLISECONDS)
                .build(loader);

        cache.getUnchecked("hello");
        assertEquals(1, cache.size());

        cache.getUnchecked("hello");
        Thread.sleep(300);

        cache.getUnchecked("test");
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }


    @Test
    public void weakKeyHasNoRef() throws InterruptedException {
        CacheLoader<MyKey, String> loader=CacheLoader.from(key->key.getKey()+" reference");
        LoadingCache<MyKey, String> cache = CacheBuilder.newBuilder().weakKeys().build(loader);
        MyKey key = new MyKey("weak");

        String value = cache.getUnchecked(key);
        assertEquals(value,"weak reference");
        key=null;
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        assertEquals(1,cache.size());
        System.out.println(cache.asMap());
    }

    @Data
    private static class MyKey{
        String key;

        public MyKey(String key) {
            this.key = key;
        }
    }


    @Test
    public void whenSoftValue_thenRemoveFromCache() throws ExecutionException, InterruptedException {
        CacheLoader<String, BigObject> loader;
        loader = CacheLoader.from(key->new BigObject(key));

        LoadingCache<String, BigObject> cache;
        cache = CacheBuilder.newBuilder().softValues().build(loader);
        cache.getUnchecked("first");
        assertEquals(1,cache.size());
        System.out.println(cache.asMap());

        //System.gc();
        cache.getUnchecked("second");
        assertEquals(1,cache.size());
        System.out.println(cache.asMap());
    }

    class BigObject{
        String id;
        byte[] bytes;
        BigObject(String id){
            this.id=id;
            bytes = new byte[1024 * 1024 * 2];
        }

    }


    @Test
    public void whenNullValue_thenOptional() {
        CacheLoader<String, Optional<String>> loader;
        loader  = CacheLoader.from(key->Optional.ofNullable(getSuffix(key)));

        LoadingCache<String, Optional<String>> cache;
        cache = CacheBuilder.newBuilder().build(loader);

        assertEquals("txt", cache.getUnchecked("text.txt").get());
        assertFalse(cache.getUnchecked("hello").isPresent());
    }
    private String getSuffix(final String str) {
        int lastIndex = str.lastIndexOf('.');
        if (lastIndex == -1) {
            return null;
        }
        return str.substring(lastIndex + 1);
    }


   @Test
   void  refreshCache() throws ExecutionException {
        //自动刷新
       CacheLoader<String, String> loader;
       loader =getCacheLoader();

       LoadingCache<String, String> cache;
       cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1,TimeUnit.MINUTES)
                .build(loader);

       //手动刷新
       String value = cache.get("key");
       cache.refresh("key");
   }


    @Test
    public void usePutAll() {
        CacheLoader<String, String> loader;
        loader = getCacheLoader();

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().build(loader);

        Map<String, String> map = new HashMap<>();
        map.put("first", "FIRST");
        map.put("second", "SECOND");
        cache.putAll(map);

        assertEquals(2, cache.size());
    }

    @Test
    public void useListener() {
        CacheLoader<String, String> loader;
        loader =  getCacheLoader();

        RemovalListener<String, String> listener;
        listener = n -> {
            if (n.wasEvicted()) {
                String cause = n.getCause().name();
                assertEquals(RemovalCause.SIZE.toString(),cause);
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
    }


    @Test
    public void useForwarding(){
        Cache<String, Object> cache =
                CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        LoggingForwardingCache<String, Object> loggingCache = new LoggingForwardingCache<>(cache);
        loggingCache.put("forward","loggingCache");
        Object forward = loggingCache.getIfPresent("forward");
        assertEquals("loggingCache",forward);
    }
}
