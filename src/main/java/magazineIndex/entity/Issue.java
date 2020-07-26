package magazineIndex.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.Size;

import magazineIndex.controller.MagazineController;
import magazineIndex.entity.Publication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Issue implements Comparable<Issue> {
    private static final Map<String, Integer> monthPositions = new HashMap<String, Integer>();

    static {
        monthPositions.put("January", Integer.valueOf(1));
        monthPositions.put("February", Integer.valueOf(2));
        monthPositions.put("March", Integer.valueOf(3));
        monthPositions.put("April", Integer.valueOf(4));
        monthPositions.put("May", Integer.valueOf(5));
        monthPositions.put("June", Integer.valueOf(6));
        monthPositions.put("July", Integer.valueOf(7));
        monthPositions.put("August", Integer.valueOf(8));
        monthPositions.put("September", Integer.valueOf(9));
        monthPositions.put("October", Integer.valueOf(10));
        monthPositions.put("November", Integer.valueOf(11));
        monthPositions.put("December", Integer.valueOf(12));
        monthPositions.put("", Integer.valueOf(0));
        monthPositions.put("Winter", Integer.valueOf(1));
        monthPositions.put("Spring", Integer.valueOf(2));
        monthPositions.put("Summer", Integer.valueOf(3));
        monthPositions.put("Fall", Integer.valueOf(4));
    }

    @Override
    public int compareTo(Issue issue) {
        int titleCompare = publication.getTitle().compareTo(issue.publication.getTitle());
        int yearCompare = getYear().compareTo(issue.getYear());
        int monthCompare = monthToNumber(getMonth()) - monthToNumber(issue.getMonth());
        if (titleCompare != 0) {
            return titleCompare;
        }
        if (yearCompare != 0) {
            return yearCompare;
        }
        return monthCompare;
    }

    // will take a month name, and convert it to the integer representation (ie: January -> 1, February -> 2, etc...
    int monthToNumber(String monthName) {
        return monthPositions.get(monthName.trim());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String year = null;
    private String month = null;
    private String number = null;
    @OneToOne
    @JoinColumn(name = "PUBLICATION_ID", nullable = true)
    private Publication publication = null;

    @Transient
    private List<Article> articleList = new ArrayList<Article>();

    @Column(length = 3000)
    @Size(max = 3000)
    private String articles = null;

    private static final Logger log = LoggerFactory.getLogger(Issue.class);

    public Issue() {
        super();
        log.trace("Issue(): Default constructor");
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
                id, year, month, number, publication == null ? "something null" : publication.toString(),
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

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setupForViewing(final String criteria) {
        String lines[] = articles.split("\\n");
        log.info(String.format("I have %d lines", lines.length));
        articleList = new ArrayList<Article>();
        int index = 0;
        while (index + 4 <= lines.length) {
            log.info(String.format("I am at %d of %d ", index, lines.length));

            if (criteriaIsIn(criteria, lines, index)) {
                articleList.add(new Article(lines[index], lines[index + 1], lines[index + 2], lines[index + 3]));
            }
            index += 5;
        }
        log.info(String.format("I have %d articles", articleList.size()));
    }

    private boolean criteriaIsIn(final String criteria, final String lines[], final int index) {
        for (int i = 0; i < 4; i++) {
            log.info(String.format("Checking %s", lines[index + i]));
            if (lines[index + i].toUpperCase().indexOf(criteria.toUpperCase()) >= 0) {
                log.info("Found it!");
                return true;
            }
        }
        return false;
    }

}