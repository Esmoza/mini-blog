package com.auk.project.miniblog.config;

import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.mapper.UserMapper;
import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserDto findByUserName(String userName) {
        Optional<User> user=userRepository.findByUsername(userName);
        User user1=null;
        if(user.isPresent()){
            user1=user.get();
        }
        return userMapper.mapToDto(user1);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser.map(CustomUserDetails:: new).get();
    }
}
