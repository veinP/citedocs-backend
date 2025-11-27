package citedocs.Service;


import citedocs.Entity.DocumentsEntity;
import citedocs.Entity.RequestsEntity;
import citedocs.Repository.DocumentsRepository;
import citedocs.Repository.RequestsRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class RequestsService {


private final RequestsRepository reqRepo;
private final DocumentsRepository docRepo;


public RequestsService(RequestsRepository reqRepo, DocumentsRepository docRepo) {
this.reqRepo = reqRepo;
this.docRepo = docRepo;
}


public List<RequestsEntity> getAll() {
return reqRepo.findAll();
}


public RequestsEntity getById(Long id) {
return reqRepo.findById(id).orElse(null);
}


public RequestsEntity create(RequestsEntity req, Long documentId) {
DocumentsEntity doc = docRepo.findById(documentId).orElse(null);
req.setDocument(doc);
return reqRepo.save(req);
}


public RequestsEntity update(Long id, RequestsEntity updatedReq) {
return reqRepo.findById(id).map(req -> {
req.setUserId(updatedReq.getUserId());
req.setStatus(updatedReq.getStatus());
req.setCopies(updatedReq.getCopies());
req.setDateNeeded(updatedReq.getDateNeeded());
req.setDocument(updatedReq.getDocument());
return reqRepo.save(req);
}).orElse(null);
}


public boolean delete(Long id) {
if (reqRepo.existsById(id)) {
reqRepo.deleteById(id);
return true;
}
return false;
}
}