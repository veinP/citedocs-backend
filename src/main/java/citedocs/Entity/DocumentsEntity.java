package citedocs.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "documents")
public class DocumentsEntity {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long documentId;


private String name;


@Column(columnDefinition = "TEXT")
private String description;


// Getters and Setters
public Long getDocumentId() { return documentId; }
public void setDocumentId(Long documentId) { this.documentId = documentId; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
}