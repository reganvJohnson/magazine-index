package magazineIndex.repository;

import java.util.List;
import magazineIndex.entity.Publication;

import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, Long> {

    List<Publication> findByTitle(String title);
}
