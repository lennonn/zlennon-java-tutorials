package com.zlennon.webflux.repository;

import com.zlennon.webflux.entity.Permission;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PermissionRepository extends R2dbcRepository<Permission, String> {
}