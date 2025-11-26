package citedocs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citedocs.Entity.RequestStatusLogEntity;
import citedocs.Repository.RequestStatusLogRepository;

@SuppressWarnings("null")
@Service
public class RequestStatusLogService {
    @Autowired
    public RequestStatusLogRepository rrepo;

    public RequestStatusLogEntity postRequestStatusLog(RequestStatusLogEntity log){
        return rrepo.save(log);
    }

    public List<RequestStatusLogEntity>getAllRequestStatusLog(){
        return rrepo.findAll();
    }

    @SuppressWarnings("finally")
    public RequestStatusLogEntity updateRequestStatusLog(int id, RequestStatusLogEntity newLogDetails){
        RequestStatusLogEntity log = new RequestStatusLogEntity();

        try{
            log = rrepo.findById(id).get();

            log.setRequestId(newLogDetails.getRequestId());
            log.setOldStatus(newLogDetails.getOldStatus());
            log.setNewStatus(newLogDetails.getNewStatus());
            log.setChangeBy(newLogDetails.getChangeBy());
            log.setChangedAt(newLogDetails.getChangedAt());
        }
        catch(NoSuchElementException ex){
            throw new NoSuchElementException("Log " + id + " does not exist.");
        }
        finally{
            return rrepo.save(log);
        }   
    }

    public String deleteRequestStatusLog(int id){
        String msg = "";
        if(rrepo.findById(id).isPresent()){
            rrepo.deleteById(id);
            msg = "Log" + id + " is successfully deleted!";
        }
        else{
            msg = "Log" + id + " does not exist.";
        }
        return msg;
    }
}