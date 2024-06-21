package com.example.board.domain.article.repositories;

import com.example.board.config.JpaConfig;
import com.example.board.domain.article.entities.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("testdb")
@Import(JpaConfig.class)
@DataJpaTest
class ArticleRepositoryTest {
    private final ArticleRepository articleRepository;

    public ArticleRepositoryTest(@Autowired ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public static Article getArticle() {
        return Article.createArticle("title", "content", "hashtag");
    }

    @Test
    void createTest() {
        // Given
        Article expectedArticle = getArticle();

        // When
        Article article = articleRepository.save(expectedArticle);

        // Then
        assertEquals(expectedArticle.getTitle(), article.getTitle());
    }

}
