package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long > {

   void saveAndFlush(Category category);

    Optional<Category> findById(Long id);
}
