package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.UserDto;
import com.vti.demorail79app.form.UserCreateForm;
import com.vti.demorail79app.mapper.UserMapper;
import com.vti.demorail79app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }
}
