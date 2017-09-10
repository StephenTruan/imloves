package com.imloves.repository;

import com.imloves.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wujianchuan
 * 2017/8/23 16:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysUserRepositoryTest {

    @Autowired
    SysUserRepository sysUserRepository;

    @Test
    public void findByOpenId() throws Exception {

        log.info(String.valueOf(sysUserRepository.findByOpenId("123456789")));
    }

    @Test
    public void findByPhone() throws Exception {

        log.info(String.valueOf(sysUserRepository.findByPhone("18231926271")));
    }

    @Test
    public void update() {

        SysUser sysUser = sysUserRepository.findByPhone("13231525262");
        sysUser.setSex(2);
        sysUserRepository.save(sysUser);
    }
}
