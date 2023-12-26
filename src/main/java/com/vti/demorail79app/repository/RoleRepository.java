package com.vti.demorail79app.repository;

import com.vti.demorail79app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByType(Role.Type type);
}
