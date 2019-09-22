package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    //In this case a query annotation is not need since spring constructs the query from the method name
	//public List<ReleaseDateType> findByCacheMedia_Id(Integer id); 
}
