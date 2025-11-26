package citedocs.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;

    private int userId;
    private int requestId;

    @Column(columnDefinition = "TEXT")
    private String message;

    private boolean isRead;
    private Timestamp createdAt;

    public NotificationEntity() {}

    public NotificationEntity(int notificationId, int userId, int requestId, String message, boolean isRead, Timestamp createdAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.requestId = requestId;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

