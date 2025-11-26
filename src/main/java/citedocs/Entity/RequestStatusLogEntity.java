package citedocs.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "request_status_log")
public class RequestStatusLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    private int requestId;
    private String oldStatus;
    private String newStatus;
    private int changeBy;
    private Timestamp changedAt;

    public RequestStatusLogEntity(){}

    public RequestStatusLogEntity(int logId, int requestId, String oldStatus, String newStatus, int changeBy, Timestamp changedAt){
        this.logId = logId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changeBy = changeBy;
        this.changedAt = changedAt;
    }

    public int getLogId(){
        return logId;
    }

    public void setLogId(int logId){
        this.logId = logId;
    }

    public int getRequestId(){
        return requestId;
    }

    public void setRequestId(int requestId){
        this.requestId = requestId;
    }

    public String getOldStatus(){
        return oldStatus;
    }

    public void setOldStatus(String oldStatus){
        this.oldStatus = oldStatus;
    }

    public String getNewStatus(){
        return newStatus;
    }

    public void setNewStatus(String newStatus){
        this.newStatus = newStatus;
    }

    public int getChangeBy(){
        return changeBy;
    }

    public void setChangeBy(int changeBy){
        this.changeBy = changeBy;
    }

    public Timestamp getChangedAt(){
        return changedAt;
    }

    public void setChangedAt(Timestamp changedAt){
        this.changedAt = changedAt;
    }
}

