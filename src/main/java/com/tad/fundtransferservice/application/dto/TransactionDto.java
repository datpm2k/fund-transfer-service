package com.tad.fundtransferservice.application.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private String id;
    private long amount;
}
