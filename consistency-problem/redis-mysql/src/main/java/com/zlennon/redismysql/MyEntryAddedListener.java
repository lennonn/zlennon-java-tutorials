package com.zlennon.redismysql;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.listener.ListAddListener;
import org.redisson.api.map.event.EntryCreatedListener;
import org.redisson.api.map.event.EntryEvent;
import org.redisson.api.map.event.EntryExpiredListener;
import org.redisson.api.map.event.EntryUpdatedListener;


@Slf4j
public class MyEntryAddedListener<String,Account> implements EntryUpdatedListener<String,Account>, EntryCreatedListener<String,Account>, EntryExpiredListener<String,Account> {
    @Override
    public void onUpdated(EntryEvent<String,Account> entryEvent) {
        log.info(entryEvent.toString());
    }

    @Override
    public void onCreated(EntryEvent<String,Account> entryEvent) {
        log.info(entryEvent.toString());
    }

    @Override
    public void onExpired(EntryEvent<String,Account> entryEvent) {
        log.info(entryEvent.toString());
    }
}
