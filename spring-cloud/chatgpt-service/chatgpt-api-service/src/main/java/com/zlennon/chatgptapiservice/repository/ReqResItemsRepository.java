package com.zlennon.chatgptapiservice.repository;

import com.zlennon.chatgptapiservice.model.ReqResItemsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReqResItemsRepository   extends CrudRepository<ReqResItemsEntity, Long>{

    @Query(value = "SELECT * FROM req_res_items",nativeQuery=true)
    List<ReqResItemsEntity> findA();

    @Query(value = "SELECT * FROM req_res_items where chat_id= ?1",nativeQuery=true)
    ReqResItemsEntity getChatGPTById(Long id);
}
