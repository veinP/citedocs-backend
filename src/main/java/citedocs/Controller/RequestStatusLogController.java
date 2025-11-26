package citedocs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import citedocs.Entity.RequestStatusLogEntity;
import citedocs.Service.RequestStatusLogService;

@RestController
@RequestMapping("/api/requeststatuslog")

public class RequestStatusLogController {
    @Autowired
    public RequestStatusLogService rserv;

    @PostMapping("/postRequestStatusLog")
    public RequestStatusLogEntity postRequestStatusLogEntity(@RequestBody RequestStatusLogEntity log){
        return rserv.postRequestStatusLog(log);
    }

    @GetMapping("/getRequestStatusLog")
    public List<RequestStatusLogEntity>getAllRequestStatusLog(){
        return rserv.getAllRequestStatusLog();
    }

    @PutMapping("/putRequestStatusLog")
    public RequestStatusLogEntity updateRequestStatusLog(@RequestParam int id, @RequestBody RequestStatusLogEntity newLogDetails){
        return rserv.updateRequestStatusLog(id, newLogDetails);
    }

    @DeleteMapping("/deleteRequestStatusLog")
    public String deleteRequestStatusLog(@PathVariable int id){
        return rserv.deleteRequestStatusLog(id);
    }

}