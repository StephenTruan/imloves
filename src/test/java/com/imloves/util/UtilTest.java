package com.imloves.util;

import org.junit.Test;

/**
 * Created by wujianchuan
 * 2017/8/19 14:33
 */
public class UtilTest {

    @Test
    public void encryptionUtilTest() {

        System.out.println(EncryptionUtil.enctyption("000000",EncryptionUtil.MD5));
    }
}