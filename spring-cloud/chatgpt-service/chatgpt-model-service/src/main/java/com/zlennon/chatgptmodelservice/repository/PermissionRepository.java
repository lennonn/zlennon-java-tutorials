package com.zlennon.chatgptmodelservice.repository;

import com.zlennon.chatgptmodelservice.entity.Model;
import com.zlennon.chatgptmodelservice.entity.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, String> {
}