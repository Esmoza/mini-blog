package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.dto.UserUpdatePasswordDto;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.mapper.UserMapper;
import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto findByUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        User user1 = null;
        if (user.isPresent()) {
            user1 = user.get();
        }
        return userMapper.mapToDto(user1);
    }

    public void save(User user) {
        user.setEnabled(true);
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.mapToDto(userRepository.save(user));
    }

    public User getUserByUserName() {
        String currentUserName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        User user = userRepository.getUserByusername(currentUserName);

        return user;
    }

    public void changePassword(UserUpdatePasswordDto userUpdateDto) {
         User user=getUserByUserName();
      if(bCryptPasswordEncoder.matches(userUpdateDto.getOldPassword()
              , user.getPassword())){
            user.setPassword(bCryptPasswordEncoder.encode(userUpdateDto.getNewPassword()));
        }
        userRepository.save(user);
    }
}
