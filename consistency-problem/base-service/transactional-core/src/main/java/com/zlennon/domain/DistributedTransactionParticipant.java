package com.zlennon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributedTransactionParticipant {

    private String serviceId;

    private DistributedTransactionStatus status;

}
