package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.CommentAndUserDto;
import com.auk.project.miniblog.dto.CommentDto;
import com.auk.project.miniblog.dto.UserUpdatePasswordDto;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.Comment;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.mapper.CommentMapper;
import com.auk.project.miniblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;

   public void save(CommentAndUserDto commentAndUserDto) {
       User user=userService.getUserByUserName();
      // Comment comment =commentMapper.mapToEntity(commentAndUserDto);
       Comment comment= null;
       comment.setUserId(user.getId());
       comment.setCommendBody(commentAndUserDto.getCommendBody());
       comment.getCreatedAt(LocalDateTime.now());
         commentRepository.save(comment);
    }
}
