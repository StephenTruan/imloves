package com.imloves.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wujianchuan
 * 2017/09/03 10:49
 */
@Component
public class RegexUtil {

    private static final String MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,1-9]))\\d{8}$";
    private static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    public boolean isMobile(String mobile) {

        Pattern pattern = Pattern.compile(MOBILE);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    public boolean isEmail(String email) {

        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
