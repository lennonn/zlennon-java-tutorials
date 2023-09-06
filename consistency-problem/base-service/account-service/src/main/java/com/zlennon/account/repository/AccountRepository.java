package com.zlennon.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zlennon.account.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

    @Modifying
    @Query(value = "UPDATE accounts set balance =?2,frozen=?3 where id=?1",nativeQuery=true)
    void updateFrozen(Long userId, int banlance, int frozen);
    @Modifying
    @Query(value = "UPDATE accounts set balance =?2 where id=?1",nativeQuery=true)
    void updateFrozenToResidue(long userId, int money);
    @Modifying
    @Query(value = "UPDATE accounts set frozen=?2 where id=?1",nativeQuery=true)
    void updateFrozenToUsed(long userId, int money);
}
