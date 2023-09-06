package com.zlennon.authorizationserver.repository;

import com.zlennon.authorizationserver.user.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long>{

   @Query(value = "select * from sys_user  where username=?1",nativeQuery=true)
    SysUser loadByUserName(String username);
}




