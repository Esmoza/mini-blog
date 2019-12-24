package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long > {
}
