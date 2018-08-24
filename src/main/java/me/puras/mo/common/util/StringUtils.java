package me.puras.mo.common.util;

import java.util.Date;
import java.util.Random;

public class StringUtils {
    public static String randomCode(int size) {
        Random random = new Random(new Date().getTime());
        String code = String.valueOf(random.nextInt());
        return code.substring(code.length() - size);
    }
}
