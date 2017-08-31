package com.imloves.auth;

import com.imloves.config.JwtAccountConfig;
import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import com.imloves.security.JwtTokenUtil;
import com.imloves.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by wujianchuan
 * 2017/8/29 13:56
 */

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final SysUserRepository sysUserRepository;
    private final JwtAccountConfig jwtAccountConfig;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            SysUserRepository sysUserRepository,
            JwtAccountConfig jwtAccountConfig) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.sysUserRepository = sysUserRepository;
        this.jwtAccountConfig = jwtAccountConfig;
    }

    @Override
    public SysUser register(SysUser user) {

        final String username = user.getUsername();
        if (sysUserRepository.findByUsername(username) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        user.setRoles(Collections.singletonList("ROLE_USER"));
        return sysUserRepository.save(user);
    }

    @Override
    public String login(String username, String password) {

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {

        final String token = oldToken.substring(jwtAccountConfig.getTokenHead().length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
