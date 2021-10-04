package com.project.shopping.service.implement;

import com.project.shopping.model.Roles;
import com.project.shopping.repository.RolesRepository;
import com.project.shopping.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService implements IRolesService {
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public Iterable<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(Integer id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void delete(Integer id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Roles findByRole(String role) {
        return rolesRepository.findByRole(role);
    }
}
