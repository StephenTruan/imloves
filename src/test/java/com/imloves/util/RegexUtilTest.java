package com.imloves.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wujianchuan
 * 2017/09/03 11:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RegexUtilTest {

    @Autowired
    RegexUtil regexUtil;

    @Test
    public void isMobile() throws Exception {

        String mobile = "18231926271";
        log.info(String.valueOf(regexUtil.isMobile(mobile)));
    }

    @Test
    public void isEmail() throws Exception {

        String email = "18231926271@163.com";
        log.info(String.valueOf(regexUtil.isEmail(email)));
    }

}