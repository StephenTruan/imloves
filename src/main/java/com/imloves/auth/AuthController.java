package com.imloves.auth;

import com.imloves.config.JwtAccountConfig;
import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import com.imloves.security.JwtAuthenticationRequest;
import com.imloves.security.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wujianchuan
 * 2017/8/29 15:50
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final JwtAccountConfig jwtAccountConfig;

    private final AuthService authService;

    private final SysUserRepository sysUserRepository;

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

        final String token = authService.login(authenticationRequest.getPhone(), authenticationRequest.getPassword());
        final SysUser user = sysUserRepository.findByPhone(authenticationRequest.getPhone());
        return new Auth(token, user);
    }

    @GetMapping(value = "/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(jwtAccountConfig.getTokenHead());
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }
}
