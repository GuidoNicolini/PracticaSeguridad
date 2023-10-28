package com.seguridadjwt.seguridad.services.implementation;

import com.seguridadjwt.seguridad.models.Users;
import com.seguridadjwt.seguridad.repositories.UserRepository;
import com.seguridadjwt.seguridad.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

}