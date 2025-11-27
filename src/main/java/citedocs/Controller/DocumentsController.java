package citedocs.Controller;


import citedocs.Entity.DocumentsEntity;
import citedocs.Service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/documents")
@CrossOrigin("*")
public class DocumentsController {


@Autowired
private DocumentsService service;


@PostMapping("/postDocument")
public DocumentsEntity postDocument(@RequestBody DocumentsEntity doc) {
return service.create(doc);
}


@GetMapping("/getDocuments")
public List<DocumentsEntity> getAllDocuments() {
return service.getAll();
}


@GetMapping("/getDocument")
public DocumentsEntity getDocument(@RequestParam Long id) {
return service.getById(id);
}


@PutMapping("/putDocument")
public DocumentsEntity updateDocument(@RequestParam Long id, @RequestBody DocumentsEntity doc) {
return service.update(id, doc);
}


@DeleteMapping("/deleteDocument")
public String deleteDocument(@RequestParam Long id) {
return service.delete(id) ? "Document deleted successfully" : "Document not found";
}
}