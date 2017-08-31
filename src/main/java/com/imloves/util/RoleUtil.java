package com.imloves.util;

import com.imloves.model.SysRole;
import com.imloves.model.SysUser;
import com.imloves.model.SysUserRole;
import com.imloves.repository.SysRoleRepository;
import com.imloves.repository.SysUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/29 15:13
 */
@Component
public class RoleUtil {

    private final SysRoleRepository sysRoleRepository;

    private final SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    public RoleUtil(SysRoleRepository sysRoleRepository, SysUserRoleRepository sysUserRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    public List<String> getRoleNamesByUser(SysUser sysUser) {

        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findByUserId(sysUser.getId());
        List<Integer> roleIds = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();
        sysUserRoles.forEach(sysUserRole -> roleIds.add(sysUserRole.getRoleId()));
        List<SysRole> sysRoles = sysRoleRepository.findSysRolesByIdIn(roleIds);
        sysRoles.forEach(sysRole -> roleNames.add(sysRole.getName()));
        return roleNames;
    }
}
