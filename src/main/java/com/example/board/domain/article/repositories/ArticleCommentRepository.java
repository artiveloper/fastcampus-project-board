package com.example.board.domain.article.repositories;

import com.example.board.domain.article.entities.ArticleComment;
import com.example.board.domain.article.entities.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment> {

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // list 는 검색대상에서 제외
        bindings.excludeUnlistedProperties(false);
        // 검색대상에 포함시킬 컬럼
        bindings.including(root.content, root.createdAt, root.createdBy);
        // match rule 변경
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%%'
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
    }
}
