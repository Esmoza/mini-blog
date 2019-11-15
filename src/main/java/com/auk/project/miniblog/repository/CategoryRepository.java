package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CategoryRepository extends JpaRepository<Category,Long > {
}
