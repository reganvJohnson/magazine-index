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
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "article_Sequence")
    @SequenceGenerator(name = "article_Sequence", sequenceName = "ARTICLE_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @Column(name="page")
    private Integer page;

    @Column(name="title")
    private String title;

    @Column(name="summary")
    private String summary;

    public Article() {
    }
        // getters/setters
}
