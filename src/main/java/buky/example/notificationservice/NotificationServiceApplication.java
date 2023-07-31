package buky.example.notificationservice;

import buky.example.notificationservice.model.Notification;
import buky.example.notificationservice.model.enums.NotificationType;
import buky.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class NotificationServiceApplication implements CommandLineRunner {

	private final NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Notification notification = Notification.builder().notificationType(NotificationType.HOST_RATING)
				.createdAt(LocalDateTime.now()).processed(false).receiverId(1L).subjectId(1L).build();

		notificationService.saveNotification(notification);

	}
}
