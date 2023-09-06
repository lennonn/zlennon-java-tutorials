package com.zlennon.repository;

import com.zlennon.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    @Modifying
    @Query(value = "UPDATE products set quantity =?2,frozen=?3 where id=?1",nativeQuery=true)
    int updateFrozen(Long productId, int quantity, int forzen);
    @Modifying
    @Query(value = "UPDATE products set quantity =?2 where id=?1",nativeQuery=true)
    int updateFrozenToUsed(long productId, int count);
    @Modifying
    @Query(value = "UPDATE products set frozen =?2 where id=?1",nativeQuery=true)
    int updateFrozenToResidue(long productId, int count);
}
