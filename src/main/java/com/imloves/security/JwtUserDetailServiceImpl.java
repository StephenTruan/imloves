package com.imloves.security;

import com.imloves.model.SysRole;
import com.imloves.model.SysUser;
import com.imloves.model.SysUserRole;
import com.imloves.repository.SysRoleRepository;
import com.imloves.repository.SysUserRepository;
import com.imloves.repository.SysUserRoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/2/5.
 */
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    private final SysRoleRepository sysRoleRepository;

    private final SysUserRoleRepository sysUserRoleRepository;

    public JwtUserDetailServiceImpl(SysUserRepository sysUserRepository, SysRoleRepository sysRoleRepository, SysUserRoleRepository sysUserRoleRepository) {
        this.sysUserRepository = sysUserRepository;
        this.sysRoleRepository = sysRoleRepository;
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findSysUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在");
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.findSysUserRoleByUserId(user.getId());
        List<Integer> roleIds = new ArrayList<>();
        List<SysRole> sysRoles;
        sysUserRoles.forEach(sysUserRole -> roleIds.add(sysUserRole.getRoleId()));
        sysRoles = sysRoleRepository.findSysRolesByIdIn(roleIds);
        user.setRoles(sysRoles);
        return JwtUserFactory.create(user);
    }
}
