package magazineIndex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import magazineIndex.entity.Publication;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String year;
    private String month;
    private String number;

    //private Long hobbyId;
    @OneToOne
    @JoinColumn(name="PUBLICATION_ID", nullable=true)
    private Publication publication;

    //protected Issue() {}

    public Issue() {
        setYear("");
        setMonth("");
        setNumber("");
        setPublication(null);
    }

    public Issue(String year, String month, String number, Publication publication) {
        setYear(year);
        setMonth(month);
        setNumber(number);
        setPublication(publication);
    }
    @Override
    public String toString() {
        return String.format(
                "Issue[id=%d, year='%s', month='%s', number='%s', publication='%s']",
                id, year, month, number, publication== null? "something null": publication.getTitle());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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