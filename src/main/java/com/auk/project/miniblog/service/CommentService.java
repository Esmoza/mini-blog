package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.CommentDto;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.Comment;
import com.auk.project.miniblog.mapper.CommentMapper;
import com.auk.project.miniblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;


   public void save(@Valid CommentDto commentDto) {
         Comment comment=commentMapper.mapToEntity(commentDto);
        // commentDto.setArticles(commentDto.getArticles(g));
        // commentDto1.setAuthorEmail(commentDto.getAuthorEmail());
         comment.setCommendBody(commentDto.getCommendBody());
         commentRepository.saveAndFlush(comment);
    }
}
