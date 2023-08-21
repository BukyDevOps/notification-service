package buky.example.notificationservice.service;

import buky.example.notificationservice.model.Notification;
import buky.example.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void addNewNotification(Notification message) {
        notificationRepository.save(message);

        if(!message.getProcessed()){
            sendNotificationToUser(message.getReceiverId(), message.getMessage());
        }
    }

    public List<Notification> getMyNotifications(Long userId) {
        return notificationRepository.findAllByReceiverIdAndProcessedFalse(userId);
    }

    public void sendNotificationToUser(Long userId, String message) {
        messagingTemplate.convertAndSend("/socket-publisher/" + userId, message);
    }
}

