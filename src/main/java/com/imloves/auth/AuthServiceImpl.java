package com.imloves.auth;

import com.imloves.config.JwtAccountConfig;
import com.imloves.model.SysUser;
import com.imloves.model.SysUserRole;
import com.imloves.repository.SysUserRepository;
import com.imloves.repository.SysUserRoleRepository;
import com.imloves.security.JwtTokenUtil;
import com.imloves.security.JwtUser;
import com.imloves.security.JwtUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by wujianchuan
 * 2017/8/29 13:56
 */

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final SysUserRepository sysUserRepository;
    private final JwtAccountConfig jwtAccountConfig;
    private final SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            JwtUserDetailServiceImpl userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            SysUserRepository sysUserRepository,
            JwtAccountConfig jwtAccountConfig,
            SysUserRoleRepository sysUserRoleRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.sysUserRepository = sysUserRepository;
        this.jwtAccountConfig = jwtAccountConfig;
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    @Override
    public SysUser register(SysUser user) {

        final String phone = user.getPhone();
        if (sysUserRepository.findByPhone(phone) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        user.setSex(0);
        user.setState(1);
        SysUser sysUser = sysUserRepository.save(user);
        SysUserRole sysUserRole = new SysUserRole(sysUser.getId(), 1);
        sysUserRoleRepository.save(sysUserRole);
        return sysUser;
    }

    @Override
    public String login(String phone, String password) {

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(phone, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final JwtUser userDetails = userDetailsService.loadUserByUsername(phone);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {

        final String token = oldToken.substring(jwtAccountConfig.getTokenHead().length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
