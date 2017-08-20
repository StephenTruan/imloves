package com.imloves.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/20 10:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void findRoleNamesByPhoneTest() {

        List<String> roleNames = roleRepository.findRoleNamesByPhone("15603250520");
        roleNames.forEach(name -> System.out.println(name));
    }
}