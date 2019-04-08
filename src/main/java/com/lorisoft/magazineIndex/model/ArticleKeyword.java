package com.lorisoft.magazineIndex.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ArticleKeyword {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "articleKeyword_Sequence")
    @SequenceGenerator(name = "articleKeyword_Sequence", sequenceName = "ARTICLEKEYWORD_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", nullable=false)
    private Issue issue;
    
    public ArticleKeyword() {
    }
        // getters/setters
}

