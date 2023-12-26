package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.UserDto;
import com.vti.demorail79app.entity.Role;
import com.vti.demorail79app.form.UserCreateForm;
import com.vti.demorail79app.mapper.UserMapper;
import com.vti.demorail79app.repository.RoleRepository;
import com.vti.demorail79app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var savedUser = userRepository.save(user);
        var role = roleRepository.findByType(Role.Type.USER);
        user.setRoles(Set.of(role));
        return UserMapper.map(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        var authorities = new ArrayList<GrantedAuthority>();
        var roles = user.getRoles();
        for (Role role : roles) {
            var authority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(authority);
        }
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
