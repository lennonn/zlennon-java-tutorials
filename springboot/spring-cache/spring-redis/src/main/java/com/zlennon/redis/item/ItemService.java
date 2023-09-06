package com.zlennon.redis.item;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Cacheable(value = "itemCache")
    public Item getItemForId(String id) {
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }


    @Cacheable(value = "customerCache")
    public Item getCustomItem(String id) {
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Cacheable(value = "useCacheManager")
    public Item cacheUseCacheManager(String id) {
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}