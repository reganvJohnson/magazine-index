package magazineIndex.viewClasses;



import magazineIndex.entity.Issue;
public class IssueAdd {

	Issue issue;
	String publicationSelectedValue;
	public Issue getIssue() {
		return issue;
	}
	
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	public String getPublicationSelectedValue() {
		return publicationSelectedValue;
	}

	public void setPublicationSelectedValue(String publicationSelectedValue) {
		this.publicationSelectedValue = publicationSelectedValue;
	}

	@Override
	public String toString() {
		return "IssueAdd [issue=" + issue + ", publicationSelectedValue=" + publicationSelectedValue;
	}
}
