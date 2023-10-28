package com.seguridadjwt.seguridad.controllers;

import com.seguridadjwt.seguridad.models.Users;
import com.seguridadjwt.seguridad.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Users user) {
        user.setPassword(bcrypt.encode(user.getPassword()));
        return ResponseEntity.ok(userService.save(user));
    }
}