package com.imloves.repository;

import com.imloves.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long> {

    List<SysUserRole> findAll();

    List<SysUserRole> findByUserId(Long userId);
}
