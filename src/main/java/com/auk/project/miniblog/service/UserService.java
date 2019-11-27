package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.mapper.UserMapper;
import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

   /* public UserDto findByUserName(String userName) {
       Optional<User> user=userRepository.findByUsername(userName);
       User user1=null;
        if(user.isPresent()){
            user1=user.get();
        }
        return userMapper.mapToDto(user1);
    }
*/
   public UserDto findByUserName(String userName) {
       Optional<User> user=userRepository.findByUsername(userName);
       User user1=null;
       if(user.isPresent()){
           user1=user.get();
       }
       return userMapper.mapToDto(user1);
   }
    public UserDto addUser(UserDto userDto){
        String userName = userDto.getLastname();
      Optional<User> user=userRepository.findByUsername(userName);
        User user1=null;
        if(user.isPresent()){
         user1=user.get();
        }
       userMapper.mapToDto(user1);
        return userDto;
    }


}
