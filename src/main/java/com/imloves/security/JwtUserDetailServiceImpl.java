package com.imloves.security;

import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import com.imloves.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/2/5.
 */
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    @Autowired
    private RoleUtil roleUtil;

    JwtUserDetailServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在");
        List<String> roleNames = roleUtil.getRoleNamesByUser(user);
        user.setRoles(roleNames);
        return JwtUserFactory.create(user);
    }
}
