package citedocs.Service;


import citedocs.Entity.DocumentsEntity;
import citedocs.Repository.DocumentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DocumentsService {


private final DocumentsRepository repo;


public DocumentsService(DocumentsRepository repo) {
this.repo = repo;
}


public List<DocumentsEntity> getAll() {
return repo.findAll();
}


public DocumentsEntity getById(Long id) {
return repo.findById(id).orElse(null);
}


public DocumentsEntity create(DocumentsEntity doc) {
return repo.save(doc);
}


public DocumentsEntity update(Long id, DocumentsEntity newDoc) {
return repo.findById(id).map(doc -> {
doc.setName(newDoc.getName());
doc.setDescription(newDoc.getDescription());
return repo.save(doc);
}).orElse(null);
}


public boolean delete(Long id) {
if (repo.existsById(id)) {
repo.deleteById(id);
return true;
}
return false;
}
}