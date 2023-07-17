package kg.infosystems.buhproject.security.infocom;

import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
    public static final String defAlg = "SHA-256";

    private EncryptionUtil() {
    }

    public static String encrypt(String alg, String message) {
        return encrypt(alg, message.getBytes(StandardCharsets.UTF_8));
    }

    public static String encrypt(String message) {
        return encrypt(defAlg, message.getBytes(StandardCharsets.UTF_8));
    }

    public static String encrypt(String alg, byte[] bytes) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            throw new InfocomException(e.toString());
        }
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        char[] chars = Hex.encode(digest);
        return String.valueOf(chars);
    }
}
