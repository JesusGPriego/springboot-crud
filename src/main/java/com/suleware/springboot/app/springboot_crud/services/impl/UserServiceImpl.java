package com.suleware.springboot.app.springboot_crud.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suleware.springboot.app.springboot_crud.entities.Role;
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
        Optional<Role> oRole = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        oRole.ifPresent(roles::add);
        if (user.isAdmin()) {
            Optional<Role> oRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            oRoleAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

}
