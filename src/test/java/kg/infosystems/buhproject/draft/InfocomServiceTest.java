package kg.infosystems.buhproject.draft;

import kg.infosystems.buhproject.security.infocom.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootTest
public class InfocomServiceTest {
    private static final String user = "20509199102533";
    private static final String org = "01211202110139";
    private static final String data = "Калысов Тилек Калысович";
    private static final String hash = EncryptionUtil.encrypt(data);
    //    private static final String hash = "3FBCE39F6274CBE69D9A843C8CB04C0B9E43776E2D6A6C17C9948C81017B92F0";
    private static final Logger log = getLogger(InfocomServiceTest.class);
    @Autowired
    private InfocomService service;

    @Test
    void testGetAuthMethods() {
        assert service != null;
        AuthMethodsResponse authMethods = service.getAuthMethods(user, org);
        log.info(authMethods.toString());
    }

    @Test
    void testGetPincode() {
        PincodeResponse email = service.getPincode(user, org, "email");
        log.info(email.toString());

        PincodeResponse sms = service.getPincode(user, org, "sms");
        log.info(sms.toString());
    }

    private final Path tokenPath = Path.of("token");
    private final Path signPath = Path.of("sign");

    @Test
    void testGetToken() throws IOException {
        String pin = "162454";
        AuthResponse token = service.getToken(user, org, pin);
        assert token.getToken() != null && !token.getToken().isEmpty();
        log.info(token.toString());
        log.warn(token.getToken());

        writeFile(tokenPath, token.getToken());
    }

    @Test
    void testGetCertInfo() throws IOException {
        String token = readFile(tokenPath);
        CertInfoResponse certInfo = service.getCertInfo(token);
        assert certInfo != null;
        log.info(certInfo.toString());
    }

    @Test
    void testGetSignature() throws IOException {
        String token = readFile(tokenPath);
        SignResponse signature = service.getSignature(hash, token);
        assert signature.getIsSuccesfull();
        log.info(signature.toString());
        log.warn(signature.getSign());

        writeFile(signPath, signature.getSign());
    }

    @Test
    void testCheckSignature() throws IOException {
        String sign = readFile(signPath);
        CheckSignResponse response = service.checkSignature(sign, hash);
        assert response.getVerified();
        log.info(response.toString());
    }

    @Test
    void testSignContent() throws IOException {
        String signature = service.signContent(user, org, "873025", hash);
        assert signature != null && signature.length() > 0;
        writeFile(signPath, signature);
    }

    @Test
    void testVerifyContent() throws IOException {
        String s = readFile(signPath);
        boolean b = service.verifyContent(s, hash);
        assert b;
    }

    private Path createFile(Path path) throws IOException {
        Files.deleteIfExists(path);
        return Files.createFile(path);
    }

    private String readFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return lines.get(0);
    }

    private void writeFile(Path path, String content) throws IOException {
        Path p = createFile(path);
        try (PrintWriter writer = new PrintWriter(p.toFile())) {
            writer.println(content);
        }
    }
}
