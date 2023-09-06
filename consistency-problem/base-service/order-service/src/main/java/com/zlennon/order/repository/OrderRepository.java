package com.zlennon.order.repository;

import com.zlennon.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select max(id) from orders",nativeQuery = true)
    long findMaxId();
}
