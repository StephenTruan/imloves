package com.imloves.auth;

import com.imloves.config.JwtAccountConfig;
import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import com.imloves.security.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wujianchuan
 * 2017/8/29 15:50
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private JwtAccountConfig jwtAccountConfig;

    private AuthService authService;

    private SysUserRepository sysUserRepository;

    @Autowired
    public AuthController(JwtAccountConfig jwtAccountConfig, AuthService authService, SysUserRepository sysUserRepository) {
        this.authService = authService;
        this.sysUserRepository = sysUserRepository;
        this.jwtAccountConfig = jwtAccountConfig;
    }

    @PostMapping(value = "/register")
    public SysUser register(@RequestBody SysUser user) throws AuthenticationException {

        return authService.register(user);
    }

    @PostMapping(value = "/login")
    public Auth createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final SysUser user = sysUserRepository.findByUsername(authenticationRequest.getUsername());
        return new Auth(token, user);
    }
}
