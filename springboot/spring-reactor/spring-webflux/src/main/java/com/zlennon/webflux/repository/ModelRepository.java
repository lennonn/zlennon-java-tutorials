package com.zlennon.webflux.repository;

import com.zlennon.webflux.entity.Model;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends R2dbcRepository<Model,String> {
}