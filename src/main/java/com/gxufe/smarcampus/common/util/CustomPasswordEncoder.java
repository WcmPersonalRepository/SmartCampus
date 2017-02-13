package com.gxufe.smarcampus.common.util;

public interface CustomPasswordEncoder {
    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}