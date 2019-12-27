package magazineIndex.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import magazineIndex.entity.Publication;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    String year;
    String month;
    String number;

    //private Long hobbyId;
    @OneToOne
    @JoinColumn(name="PUBLICATION_ID", nullable=true)
    Publication publication;
    @OneToMany (mappedBy="issue")
    List<Article> articles;
    //protected Issue() {}

    public Issue() {
        setYear("");
        setMonth("");
        setNumber("");
        setPublication(null);
        setArticles(null);
    }

    public Issue(String year, String month, String number, Publication publication, List<Article> articles) {
        setYear(year);
        setMonth(month);
        setNumber(number);
        setPublication(publication);
        setArticles(articles);
    }
    @Override
    public String toString() {
        return String.format(
                "Issue[id=%d, year='%s', month='%s', number='%s', publication='%s', articles[%s]]",
                id, year, month, number, publication== null? "something null": publication.getTitle(),
                		getArticlesList());
    }

    public String getArticlesList() {
    	if (articles == null) {
    		return "no articles";
    	}
    	String outStr = "";
    	for (Article article: articles) {
    		outStr += article.toString() + " ";
    	}
    	return outStr;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public Publication getPublication() {
        return publication;
    }

    public void setPublication (Publication publication) {
        this.publication = publication;
    }
}