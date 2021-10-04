package com.project.shopping.service.implement;

import com.project.shopping.model.Users;
import com.project.shopping.repository.UsersRepository;
import com.project.shopping.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users save(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);
    }

    @Override
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }

}
