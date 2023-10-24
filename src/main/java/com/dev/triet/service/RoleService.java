package com.dev.triet.service;

import com.dev.triet.entities.Role;
import com.dev.triet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role>{

	@Autowired
	RoleRepository repository;

	@Override
	protected Class<Role> clazz() {
		// TODO Auto-generated method stub
		return Role.class;
	}
	
	public Role loadRoleByRoleName(String roleName) {
		Role role = repository.findByName(roleName);
		return role;
	}
}
