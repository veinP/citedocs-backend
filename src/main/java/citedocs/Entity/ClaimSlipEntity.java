package citedocs.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Claim_Slips")
public class ClaimSlipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private int claimId;

    @Column(name = "request_id", nullable = false)
    private int requestId;

    @Column(name = "claim_number", nullable = false)
    private String claimNumber;

    @Column(name = "date_ready")
    private LocalDate dateReady;

    @Column(name = "issued_by")
    private int issuedBy;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    public ClaimSlipEntity() {}

    
    public int getClaimId() {
        return claimId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public LocalDate getDateReady() {
        return dateReady;
    }

    public void setDateReady(LocalDate dateReady) {
        this.dateReady = dateReady;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }
}
