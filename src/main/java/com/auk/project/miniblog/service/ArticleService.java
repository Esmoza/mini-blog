package com.auk.project.miniblog.service;

import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
   private ArticleRepository articleRepository;

    public Article findById(long id){
        return articleRepository.findById(id);
    }

}
