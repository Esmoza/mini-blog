package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.dto.PhotoDto;
import com.auk.project.miniblog.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    void save(PhotoDto photo);

   Optional<Photo> findById(Long id);
    List<Photo> findAll();
}