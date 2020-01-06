package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    void saveAndFlush(Comment comment);
}
