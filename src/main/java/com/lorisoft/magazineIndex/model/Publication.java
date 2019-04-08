package com.programmer.magazineIndex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "publication_Sequence")
    @SequenceGenerator(name = "publication_Sequence", sequenceName = "PUBLICATION_SEQ")
    private Long id;

    @Column(name="name")
    private String name;

    public Publication() {
    }
        // getters/setters
}
