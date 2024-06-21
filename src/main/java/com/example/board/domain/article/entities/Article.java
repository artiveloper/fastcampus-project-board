package com.example.board.domain.article.entities;

import com.example.board.domain.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Table(
        name = "article",
        indexes = {
                @Index(columnList = "title"),
                @Index(columnList = "hashtag"),
                @Index(columnList = "createdAt"),
                @Index(columnList = "createdBy"),
        })
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = false)
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false)
    private String content;
    @Setter
    private String hashtag;

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article createArticle(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

}
