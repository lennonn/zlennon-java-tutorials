package com.zlennon.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingCache;

import java.util.logging.Logger;

public class LoggingForwardingCache<K, V> extends ForwardingCache.SimpleForwardingCache<K, V> {
    private final Logger logger = Logger.getLogger(LoggingForwardingCache.class.getName());

    public LoggingForwardingCache(Cache<K, V> delegate) {
        super(delegate);
    }


    @Override
    public V getIfPresent(Object key) {
        V value = super.getIfPresent(key);
        if (value != null) {
            logger.info("Cache hit for key: " + key);
        }
        return value;
    }
}
