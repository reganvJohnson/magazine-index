package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    //private Long hobbyId;
    @OneToOne
    @JoinColumn(name="HOBBY_ID", nullable=true)
    private Hobby hobby;

    protected Customer() {}

    public Customer(String firstName, String lastName
    //		, Long hobbyId) {
    		, Hobby hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.hobbyId = hobbyId;
        this.hobby = hobby;
    }
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', hobby='%s']",
                id, firstName, lastName, hobby.getTitle());
    }

    public Long getId () {
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }




}