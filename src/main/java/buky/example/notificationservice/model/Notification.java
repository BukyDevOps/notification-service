package buky.example.notificationservice.model;

import buky.example.notificationservice.model.enums.NotificationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification {

    @Id
    @Field("_id")
    private String id;
    private NotificationType notificationType;
    private Long subjectId;
    private Long receiverId;
    private LocalDateTime createdAt;
    private Boolean processed;
}
