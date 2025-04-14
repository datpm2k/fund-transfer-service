package com.tad.fundtransferservice.adapters.notifications.factory;

import com.tad.fundtransferservice.application.enums.NotificationType;
import com.tad.fundtransferservice.application.ports.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class NotificationStrategyFactory {

    private final Map<NotificationType, NotificationStrategy> strategyMap;

    public NotificationStrategyFactory(List<NotificationStrategy> strategyList) {
        this.strategyMap = strategyList.stream()
                .collect(Collectors.toMap(
                        NotificationStrategy::getType, Function.identity()));
    }

    public NotificationStrategy getStrategy(NotificationType type) {
        NotificationStrategy strategy = strategyMap.get(type);
        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported notification type: " + type);
        }
        return strategy;
    }
}
