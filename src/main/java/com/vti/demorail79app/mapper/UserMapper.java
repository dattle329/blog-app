package com.vti.demorail79app.mapper;

import com.vti.demorail79app.dto.UserDto;
import com.vti.demorail79app.entity.User;
import com.vti.demorail79app.form.UserCreateForm;

public class UserMapper {
    public static User map(UserCreateForm form){
        var user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        return user;
    }

    public static UserDto map(User user){
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}
