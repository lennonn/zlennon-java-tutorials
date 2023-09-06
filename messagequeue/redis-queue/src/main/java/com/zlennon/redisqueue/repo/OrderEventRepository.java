package com.zlennon.redisqueue.repo;

import com.zlennon.redisqueue.model.OrderEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEventRepository extends CrudRepository<OrderEvent, String> {
}