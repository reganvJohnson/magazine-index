package magazineIndex.repository;

import java.util.List;

import magazineIndex.entity.Article;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByIssue(int issueId);
    //In this case a query annotation is not need since spring constructs the query from the method name
	//public List<ReleaseDateType> findByCacheMedia_Id(Integer IssueTitle
}