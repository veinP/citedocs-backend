package citedocs.Repository;


import citedocs.Entity.RequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestsRepository extends JpaRepository<RequestsEntity, Long> {}