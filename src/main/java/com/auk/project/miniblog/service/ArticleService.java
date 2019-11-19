package com.auk.project.miniblog.service;

import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.repository.ArticleRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
   private ArticleRepository articleRepository;

    public Article findBySlug(String slug){
        return articleRepository.findBySlug(slug);
    }


}
