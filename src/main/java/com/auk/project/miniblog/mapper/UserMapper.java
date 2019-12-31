package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements CustomMapper<User, UserDto> {

    @Override
    public UserDto mapToDto(User entity) {
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(entity,userDto);
        return userDto;
    }

    @Override
    public User mapToEntity(UserDto userDto) {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }

}
