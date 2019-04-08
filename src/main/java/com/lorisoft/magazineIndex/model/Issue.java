package com.programmer.magazineIndex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "issue_Sequence")
    @SequenceGenerator(name = "issue_Sequence", sequenceName = "ISSUE_SEQ")
    private Long id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "volume")
    private Integer volume;

    @Column(name="issue") 
    private Integer issue;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Publication publication;

    public Issue() {
    }
        // getters/setters
}
