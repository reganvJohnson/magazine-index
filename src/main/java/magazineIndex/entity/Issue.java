package magazineIndex.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import magazineIndex.controller.MagazineController;
import magazineIndex.entity.Publication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id = null;
    private String year = null;
    private String month = null;
    private String number = null;
    @OneToOne @JoinColumn(name="PUBLICATION_ID", nullable=true)
    private Publication publication = null;

    @Lob
    private String articles = null;

    private static final Logger log = LoggerFactory.getLogger(Issue.class);

    public Issue() {
        super();
        log.info("Issue(): Default constructor");
    }

/*
    public Issue(String year, String month, String number, Publication publication, List<Article> articles) {
        log.info("Issue(stuff): set year " + year);
        setYear(year);
        setMonth(month);
        setNumber(number);
        setPublication(publication);
        log.info("Issue(stuff): setting articles");
        setArticles(articles);
    }
 */
    @Override
    public String toString() {
        return String.format(
                "Issue[id=%d, year='%s', month='%s', number='%s', publication='%s', articles[%s]]",
                id, year, month, number, publication== null? "something null": publication.getTitle(),
                		articles);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        log.info("setId() :" + id + ":");
        this.id = id;
    }

    public String getArticles() {
        log.info("getArticles() :" + articles + ":");
		return articles;
	}

	public void setArticles(final String articles) {
        log.info("setArticles(stuff):" + articles + ":");
        this.articles = articles;
	}

	public String getYear() {
        log.info("getYear():" + year + ":");
        return year;
    }

    public void setYear(String year) {
        log.info("setYear(): " + year + ":");
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        log.info("setMonth(): " + month + ":");
        this.month = month;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        log.info("setNumbe(): " + number + ":");
        this.number = number;
    }
    public Publication getPublication() {
        return publication;
    }

    public void setPublication (Publication publication) {
        this.publication = publication;
    }
}