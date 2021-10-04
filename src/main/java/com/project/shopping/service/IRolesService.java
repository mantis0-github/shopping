package com.project.shopping.service;

import com.project.shopping.model.Roles;

public interface IRolesService extends IGeneralService<Roles> {
    Roles findByRole(String role);
}
