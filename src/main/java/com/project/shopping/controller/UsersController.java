package com.project.shopping.controller;

import com.project.shopping.model.Users;
import com.project.shopping.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService iUsersService;
    @GetMapping
    public ResponseEntity<Iterable<Users>> findAllUsers(){
        return  new ResponseEntity<>(iUsersService.findAll(), HttpStatus.OK);
    }
}
