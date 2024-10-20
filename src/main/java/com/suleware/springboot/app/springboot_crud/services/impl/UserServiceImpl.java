package com.suleware.springboot.app.springboot_crud.services.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suleware.springboot.app.springboot_crud.entities.User;
import com.suleware.springboot.app.springboot_crud.repositories.RoleRepository;
import com.suleware.springboot.app.springboot_crud.repositories.UserRepository;
import com.suleware.springboot.app.springboot_crud.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional()
    public User save(User user) {
        return userRepository.save(user);
    }

}
