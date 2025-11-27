package citedocs.Controller;


import citedocs.Entity.RequestsEntity;
import citedocs.Service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/requests")
@CrossOrigin("*")
public class RequestsController {


@Autowired
private RequestsService service;


@PostMapping("/postRequest")
public RequestsEntity postRequest(@RequestParam Long documentId, @RequestBody RequestsEntity req) {
return service.create(req, documentId);
}


@GetMapping("/getRequests")
public List<RequestsEntity> getAllRequests() {
return service.getAll();
}


@GetMapping("/getRequest")
public RequestsEntity getRequest(@RequestParam Long id) {
return service.getById(id);
}


@PutMapping("/putRequest")
public RequestsEntity updateRequest(@RequestParam Long id, @RequestBody RequestsEntity req) {
return service.update(id, req);
}


@DeleteMapping("/deleteRequest")
public String deleteRequest(@RequestParam Long id) {
return service.delete(id) ? "Request deleted successfully" : "Request not found";
}
}