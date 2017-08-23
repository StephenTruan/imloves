package com.imloves.service;

import com.imloves.factory.JwtUserFactory;
import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by gaowenfeng on 2017/2/5.
 */
@Data
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findSysUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在");
        return JwtUserFactory.create(user);
    }
}
