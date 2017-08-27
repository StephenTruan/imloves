package com.imloves.repository;

import com.imloves.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/20 9:47
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

    List<SysRole> findSysRolesByIdIn(List<Integer> roleIds);
}
