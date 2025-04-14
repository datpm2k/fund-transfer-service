package com.tad.fundtransferservice.adapters.notifications.strategy;

import com.tad.fundtransferservice.application.dto.NotificationDto;
import com.tad.fundtransferservice.application.dto.TransactionDto;
import com.tad.fundtransferservice.application.enums.NotificationType;
import com.tad.fundtransferservice.application.ports.NotificationStrategy;
import com.tad.fundtransferservice.infrastructure.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferTransactionNotification implements NotificationStrategy {

    private final KafkaProducer kafkaProducer;

    @Override
    public void send(NotificationDto notification) {
        TransactionDto transactionDto = (TransactionDto) notification.getData();

        kafkaProducer.publish("transaction", transactionDto.toString());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.FUND_TRANSFER;
    }
}
