
package com.project.shopping.controller;

import com.project.shopping.model.Roles;
import com.project.shopping.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService iRolesService;

    @PostMapping
    public ResponseEntity<Roles> createNewRole(@RequestBody Roles role) {
        return new ResponseEntity<>(iRolesService.save(role), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Roles>> getAllRoles() {
        return new ResponseEntity<>(iRolesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Roles> getRoles(@PathVariable Integer id) {
        Optional<Roles> rolesOptional = iRolesService.findById(id);
        return rolesOptional.map(role -> new ResponseEntity<>(role, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Integer id, @RequestBody Roles role) {
        Optional<Roles> rolesOptional = iRolesService.findById(id);
        return rolesOptional.map(role1 -> {
            role.setId(role1.getId());
            return new ResponseEntity<>(iRolesService.save(role), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Roles> deleteRole(@PathVariable Integer id) {
        Optional<Roles> rolesOptional = iRolesService.findById(id);
        return rolesOptional.map(role -> {
            iRolesService.delete(id);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
