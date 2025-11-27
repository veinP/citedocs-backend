package citedocs.Entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "requests")
public class RequestsEntity {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long requestId;


private Long userId;


@ManyToOne
@JoinColumn(name = "document_id")
private DocumentsEntity document;


@Enumerated(EnumType.STRING)
private Status status;


private int copies;
private LocalDate dateNeeded;


private LocalDateTime createdAt;
private LocalDateTime updatedAt;


public enum Status {
PENDING, APPROVED, REJECTED
}


@PrePersist
protected void onCreate() {
createdAt = LocalDateTime.now();
updatedAt = LocalDateTime.now();
if (status == null) status = Status.PENDING;
}


@PreUpdate
protected void onUpdate() {
updatedAt = LocalDateTime.now();
}


// Getters & Setters
public Long getRequestId() { return requestId; }
public void setRequestId(Long requestId) { this.requestId = requestId; }


public Long getUserId() { return userId; }
public void setUserId(Long userId) { this.userId = userId; }


public DocumentsEntity getDocument() { return document; }
public void setDocument(DocumentsEntity document) { this.document = document; }


public Status getStatus() { return status; }
public void setStatus(Status status) { this.status = status; }


public int getCopies() { return copies; }
public void setCopies(int copies) { this.copies = copies; }


public LocalDate getDateNeeded() { return dateNeeded; }
public void setDateNeeded(LocalDate dateNeeded) { this.dateNeeded = dateNeeded; }


public LocalDateTime getCreatedAt() { return createdAt; }
public LocalDateTime getUpdatedAt() { return updatedAt; }
}