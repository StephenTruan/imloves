package com.imloves.repository;

import com.imloves.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long> {

        List<SysUserRole> findAll();
}
