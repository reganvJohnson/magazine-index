package magazineIndex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Publication title is mandatory")
    private String title;
    
    protected Publication() {}

    public Publication(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format(
                "publication[id=%d, title='%s']",
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