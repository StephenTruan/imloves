package com.imloves.repository;

import com.imloves.model.SysUserRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysUserRoleRepositoryTest {

    @Autowired
    SysUserRoleRepository repository;

    @Test
    public void findAll() throws Exception {

        List<SysUserRole> sysUserRoles = repository.findAll();
        sysUserRoles.forEach(sysUserRole -> System.out.println(sysUserRole.getRoleId()));
    }

    @Test
    public void findSysUserRoleByUserId() {

        List<SysUserRole> sysUserRoles = repository.findSysUserRoleByUserId(1l);
        sysUserRoles.forEach(sysUserRole -> System.out.println(sysUserRole.getRoleId()));
    }
}