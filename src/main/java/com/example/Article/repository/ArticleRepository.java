package com.example.Article.repository;

import com.example.Article.entity.Article;
import com.example.Article.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContainingIgnoreCase(String title);
    List<Article> findByTags_Id(Long tagId);
    List<Article> findAllByOrderByCreatedAtDesc();
    List<Article> findAllByUser(User user);
}
