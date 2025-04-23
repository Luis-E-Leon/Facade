package subsystem;

import java.util.Base64;

public class FileEncryptor {
    public String encrypt(String content) {
        return Base64.getEncoder().encodeToString(content.getBytes());
    }

    public String decrypt(String content) {
        return new String(Base64.getDecoder().decode(content));
    }
}
