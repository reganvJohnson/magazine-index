package magazineIndex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="issue_id")
    private Issue issue;
    
    public Issue getIssue() {
		return issue;
		}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

    String title;
    String author;
    String summary;
    String keywords;

    public Article(Issue issue, String title, String author, String Summary, String keywords) {
    	setIssue(issue);
    	setTitle(title);
    	setAuthor(author);
    	setSummary(summary);
    	setKeywords(keywords);
    }

    public Article() {
        setTitle("");
        setAuthor("");
        setSummary("");
        setKeywords("");
        setIssue(null);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", summary=" + summary + ", keywords="
				+ keywords + "]";
	}
}