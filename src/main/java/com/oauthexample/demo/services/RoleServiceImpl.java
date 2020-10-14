package com.oauthexample.demo.services;

import com.oauthexample.demo.models.Role;
import com.oauthexample.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Implements the RoleService Interface
 */
@Transactional
@Service(value = "roleService")
public class RoleServiceImpl
        implements RoleService
{
    /**
     * Connects this service to the Role Model
     */
    @Autowired
    RoleRepository rolerepos;

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByName(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }
}