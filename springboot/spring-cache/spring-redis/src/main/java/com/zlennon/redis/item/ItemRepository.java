package com.zlennon.redis.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}