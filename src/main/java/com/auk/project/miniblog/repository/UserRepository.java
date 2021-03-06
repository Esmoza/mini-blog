package com.auk.project.miniblog.repository;

import com.auk.project.miniblog.dto.UserDto;

import com.auk.project.miniblog.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

   Optional<User> findByUsername(String username);
   User save(UserDto userDto);
   User save(User userDto);
   User findByEmailIgnoreCase(String email);
  // User update(String u, UserDto userDto);
   User getUserByusername(String username);
}
