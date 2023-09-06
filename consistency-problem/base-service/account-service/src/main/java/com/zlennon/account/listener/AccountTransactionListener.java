package com.zlennon.account.listener;

import com.zlennon.account.devil.AccountProcessingException;
import com.zlennon.account.event.AccountTransactionEvent;
import com.zlennon.account.service.EventBus;
import com.zlennon.domain.DistributedTransaction;
import com.zlennon.eventlistener.TransactionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

import static com.zlennon.domain.DistributedTransactionStatus.CONFIRMED;
import static com.zlennon.domain.DistributedTransactionStatus.TO_ROLLBACK;

/**
 * Class to handle transactional events for {@link AccountTransactionEvent}
 * type.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Component
@Slf4j
public class AccountTransactionListener implements TransactionListener<AccountTransactionEvent> {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EventBus eventBus;

    @Override
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleEvent(AccountTransactionEvent event) throws AccountProcessingException {
        log.debug("Handling event before commit: {}", event);
        eventBus.sendEvent(event);

        DistributedTransaction transaction = null;
        int count = 3000;
        log.info("Waiting for receiving transaction.");
        while (count > 0) {
            transaction = eventBus.receiveTransaction(event.getTransactionId());
            if (transaction == null) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException ex) {
                    log.error("Error while receiving transaction for: {}. Cause: {}", event.getTransactionId(), ex);
                }
                --count;
            } else {
                break;
            }
        }
        if (transaction == null || transaction.getStatus() != CONFIRMED) {
            log.info("Transaction received after waiting: {}", transaction);
            throw new AccountProcessingException("Distributed transaction wasn't confirmed for txnId: " + event.getTransactionId());
        }
    }

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleAfterRollback(AccountTransactionEvent event) {
        log.debug("Updating transaction[{}] status to : {} for account-service", event.getTransactionId(), TO_ROLLBACK);
        restTemplate.put(
                "http://transaction-server/transactions/{transactionId}/participants/{serviceId}/status/{status}",
                null,
                event.getTransactionId(),
                "account-service",
                TO_ROLLBACK);
    }

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCompletion(AccountTransactionEvent event) {
        log.debug("Updating transaction[{}] status to: {} for account-service.", event.getTransactionId(), CONFIRMED);
        restTemplate.put(
                "http://transaction-server/transactions/{transactionId}/participants/{serviceId}/status/{status}",
                null,
                event.getTransactionId(),
                "account-service",
                CONFIRMED);
    }

}
