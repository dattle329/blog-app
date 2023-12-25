package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.UserDto;
import com.vti.demorail79app.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);

}
