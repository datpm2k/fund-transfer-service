package com.tad.fundtransferservice.application.dto;

import com.tad.fundtransferservice.application.enums.NotificationType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private NotificationType type;
    private Object data;
}
