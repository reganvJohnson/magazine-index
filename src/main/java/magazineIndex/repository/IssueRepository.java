package magazineIndex.repository;

import java.util.List;
import magazineIndex.entity.Issue;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {

    List<Issue> findByYear(String year);
    //In this case a query annotation is not need since spring constructs the query from the method name
	//public List<ReleaseDateType> findByCacheMedia_Id(Integer IssueTitle

        @Query("FROM Issue where articles like('%Armstrong%')")
//        @Query("FROM Issue where year = '2020'")
//@Query("FROM Issue where articles ='33028'")
    List<Issue> findByFirstName(String firstName);
}