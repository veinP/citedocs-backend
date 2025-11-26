package citedocs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import citedocs.Entity.RequestStatusLogEntity;

@Repository
public interface RequestStatusLogRepository extends JpaRepository<RequestStatusLogEntity, Integer>{

}