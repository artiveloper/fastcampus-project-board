package com.example.board.domain.article.repositories;

import com.example.board.domain.article.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
