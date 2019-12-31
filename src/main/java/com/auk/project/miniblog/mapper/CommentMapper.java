package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.CommentDto;
import com.auk.project.miniblog.entity.Comment;
import com.auk.project.miniblog.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentMapper implements CustomMapper<Comment, CommentDto> {
    @Override
    public CommentDto mapToDto(Comment entity) {
       CommentDto commentDto=new CommentDto();
        BeanUtils.copyProperties(entity,commentDto);
        return commentDto;
    }

    @Override
    public Comment mapToEntity(CommentDto commentDto) {
       Comment comment=new Comment();
       BeanUtils.copyProperties(commentDto,comment);
        return comment;
    }

}
