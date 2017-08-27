package com.imloves.repository;

import com.imloves.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wujianchuan
 * 2017/8/23 17:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysRoleRepositoryTest {

    @Autowired
    SysRoleRepository repository;

    @Test
    public void findSysRolesByIdIn() throws Exception {

        List<Integer> roleIds = new ArrayList<>();
        roleIds.add(1);
        roleIds.add(2);
        List<SysRole> sysRoles = repository.findSysRolesByIdIn(roleIds);
        sysRoles.forEach(sysRole -> System.out.println(sysRole.getName()));
    }

}