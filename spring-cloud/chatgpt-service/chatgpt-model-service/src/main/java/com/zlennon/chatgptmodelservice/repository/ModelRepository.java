package com.zlennon.chatgptmodelservice.repository;

import com.zlennon.chatgptmodelservice.entity.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, String> {
}