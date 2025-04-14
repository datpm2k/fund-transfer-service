package com.tad.fundtransferservice.application.usecase;

import com.tad.fundtransferservice.application.dto.NotificationDto;
import com.tad.fundtransferservice.application.dto.TransactionDto;
import com.tad.fundtransferservice.application.enums.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TransferInternalBank {

    private final PublishNotificationUseCase publishNotificationUseCase;

    public void execute(Object transferInternalBankRequest) {

        TransactionDto transactionDto = new TransactionDto();

        // post transaction
        // push success or failed transaction to app
        NotificationDto transactionNotificationDto = NotificationDto.builder()
                .type(NotificationType.FUND_TRANSFER)
                .data(transactionDto)
                .build();
        publishNotificationUseCase.execute(transactionNotificationDto);

        // update mfa challenge
        NotificationDto updateMFANotificationDto = NotificationDto.builder()
                .type(NotificationType.MFA_UPDATE)
                .data(UUID.randomUUID().toString())
                .build();
    }
}
