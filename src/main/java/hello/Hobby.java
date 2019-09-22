package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    
//    @OneToOne(cascade=CascadeType.ALL, mappedBy="Customer")
//    private Customer customer;
 
    protected Hobby() {}

    public Hobby(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format(
                "Hobby[id=%d, title='%s']",
                id, title);
    }

    public Long getId () {
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }
}