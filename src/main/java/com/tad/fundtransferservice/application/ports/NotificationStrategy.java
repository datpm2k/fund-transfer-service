package com.tad.fundtransferservice.application.ports;

import com.tad.fundtransferservice.application.dto.NotificationDto;
import com.tad.fundtransferservice.application.enums.NotificationType;

public interface NotificationStrategy {
    void send(NotificationDto notification);

    NotificationType getType();
}
