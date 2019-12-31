package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.mapper.ArticleMapper;
import com.auk.project.miniblog.repository.ArticleRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transaction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public ArticlesDto find(String slug) {
        Optional<Article> article = Optional.ofNullable(articleRepository.findBySlug(slug));
        Article article1 = null;
        if (article.isPresent()) {
            article1 = article.get();
        }
        return articleMapper.mapToDto(article1);

    }

    public Article save(ArticlesDto articlesDto) {
        Article article = articleMapper.mapToEntity(articlesDto);
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        article.setPublished(1);
       return articleRepository.save(article);
    }

    public List<ArticlesDto> findAll() {
        return articleMapper.mapToDtoList(articleRepository.findAll());
    }

    public void saveImage(MultipartFile imageFile)throws Exception {
        String folder="/photo/";
        byte[] bytes=imageFile.getBytes();
        Path path=Paths.get(folder +imageFile.getOriginalFilename());
        System.out.println(path.toAbsolutePath());
        Files.write(path,bytes);
    }
}
