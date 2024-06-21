package com.example.board.domain.article.repositories;

import com.example.board.domain.article.entities.Article;
import com.example.board.domain.article.entities.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
