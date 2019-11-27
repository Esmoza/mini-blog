package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.mapper.ArticleMapper;
import com.auk.project.miniblog.repository.ArticleRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
   private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

      // public Article findBySlug(String slug){
     //   return articleRepository.findBySlug(slug);
    //}

public ArticlesDto find(String slug){
    Optional<Article> article = Optional.ofNullable(articleRepository.findBySlug(slug));
    Article article1 = null;
    if(article.isPresent()){
        article1=article.get();
    }
    return articleMapper.mapToDto(article1);

}

public ArticlesDto save(ArticlesDto articlesDto){
    Article article=articleMapper.mapToEntity(articlesDto);
    articlesDto.setCreatedAt(LocalDateTime.now());
    articlesDto.setUpdatedAt(LocalDateTime.now());
    articlesDto.setPublished(1);
    Article savedArticle=articleRepository.save(article);
    return articleMapper.mapToDto(savedArticle);
}

public List<ArticlesDto> findAll()
{
    return articleMapper.mapToDtoList(articleRepository.findAll());
}

}
