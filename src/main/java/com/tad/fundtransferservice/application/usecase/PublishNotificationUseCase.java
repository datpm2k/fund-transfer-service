package com.tad.fundtransferservice.application.usecase;

import com.tad.fundtransferservice.adapters.notifications.factory.NotificationStrategyFactory;
import com.tad.fundtransferservice.application.dto.NotificationDto;
import com.tad.fundtransferservice.application.ports.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishNotificationUseCase {
    private final NotificationStrategyFactory notificationStrategyFactory;

    public void execute(NotificationDto notificationDto) {
        NotificationStrategy notificationStrategy
                = notificationStrategyFactory.getStrategy(notificationDto.getType());
        notificationStrategy.send(notificationDto);
    }
}
