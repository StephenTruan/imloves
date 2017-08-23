package com.imloves.repository;

import com.imloves.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wujianchuan
 * 2017/8/19 10:56
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByOpenId(String openId);

    SysUser findByPhone(String phone);

    SysUser findSysUserByUsername(String username);
}
