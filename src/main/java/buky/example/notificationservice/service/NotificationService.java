package buky.example.notificationservice.service;

import buky.example.notificationservice.model.Notification;
import buky.example.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void addNewNotification(Notification message) {
        notificationRepository.save(message);

        if(!message.getProcessed()){
            //TODO socketi
        }
    }
}

