package buky.example.notificationservice.messaging;

import buky.example.notificationservice.model.Notification;
import buky.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notifications-topic", containerFactory = "kafkaListenerContainerFactory")
    public void newNotification(Notification message) {
        notificationService.addNewNotification(message);
    }

}