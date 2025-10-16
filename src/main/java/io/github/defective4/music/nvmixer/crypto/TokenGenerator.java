package io.github.defective4.music.nvmixer.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TokenGenerator {
    private static final char[] SALT_CHARS;
    private final MessageDigest md;
    private final SecureRandom random = new SecureRandom();

    private final int saltLength;

    static {
        StringBuilder chars = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        chars.append(chars.toString().toUpperCase());
        for (int i = 0; i <= 9; i++) chars.append(i);
        SALT_CHARS = chars.toString().toCharArray();
    }

    public TokenGenerator(int saltLength) throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("md5");
        this.saltLength = saltLength;
    }

    public String generateHash(String password, String salt) {
        byte[] digest = md.digest((password + salt).getBytes(StandardCharsets.UTF_8));
        StringBuilder hash = new StringBuilder();
        for (byte b : digest) {
            String c = Integer.toHexString(b & 0xff);
            if (c.length() == 1) c = "0" + c;
            hash.append(c);
        }
        return hash.toString();
    }

    public String generateSalt() {
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < saltLength; i++) salt.append(SALT_CHARS[random.nextInt(SALT_CHARS.length)]);
        return salt.toString();
    }
}
