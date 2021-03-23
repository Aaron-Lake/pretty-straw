package util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encode(String rawPassword){
        return "{bcrypt}"+bCryptPasswordEncoder.encode(rawPassword);
    }
}
