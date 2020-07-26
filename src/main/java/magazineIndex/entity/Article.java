package magazineIndex.entity;
public class Article {

    private String title;
	private String author;
	private String summary;
	private String keywords;

    public Article(String title, String author, String Summary, String keywords) {
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
		return "Article [title=" + title + ", author=" + author + ", summary=" + summary + ", keywords="
				+ keywords + "]";
	}
}