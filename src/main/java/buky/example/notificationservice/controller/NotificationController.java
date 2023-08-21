package buky.example.notificationservice.controller;

import buky.example.notificationservice.model.Notification;
import buky.example.notificationservice.security.HasRole;
import buky.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping()
    @HasRole("GUEST,HOST")
    public List<Notification> getMyNotifications(Long userId) {
        return notificationService.getMyNotifications(userId);
    }

    @GetMapping("/test")
    public void testNotifications() {
        notificationService.sendNotificationToUser(1L, "test");
    }
}
