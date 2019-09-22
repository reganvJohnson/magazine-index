package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HobbyRepository extends CrudRepository<Hobby, Long> {

    List<Hobby> findByTitle(String title);
}
