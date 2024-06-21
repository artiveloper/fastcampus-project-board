package com.example.board.domain.article.entities;

import com.example.board.domain.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(
        name = "article_comment",
        indexes = {
                @Index(columnList = "content"),
                @Index(columnList = "createdAt"),
                @Index(columnList = "createdBy"),
        })
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = false)
public class ArticleComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article article;
    @Column(nullable = false, length = 500)
    private String content;

    public ArticleComment(Article article, String content) {
        this.content = content;
        this.article = article;
    }
}
