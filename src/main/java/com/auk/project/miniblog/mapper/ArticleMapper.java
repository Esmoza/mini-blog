package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ArticleMapper implements  CustomMapper<Article, ArticlesDto> {

    @Override
    public ArticlesDto mapToDto(Article entity) {
        ArticlesDto articlesDto=new ArticlesDto();
        BeanUtils.copyProperties(entity,articlesDto);
        return articlesDto;
    }

    @Override
    public Article mapToEntity(ArticlesDto articlesDto) {
       Article article=new Article();
       BeanUtils.copyProperties(articlesDto,article);
        return article;
    }

    public List<ArticlesDto> mapToDtoList(Iterable<Article> articles){
        List<ArticlesDto> articlesDtos=new ArrayList<>();
        for(Article article : articles){
            articlesDtos.add(mapToDto(article));
        }
        return articlesDtos;

    }
}
