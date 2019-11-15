package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findById(long id);
}
