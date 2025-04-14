package com.tad.fundtransferservice.domain.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {
    private UUID id;
    private String amount;
    private LocalDateTime transDate;
}
