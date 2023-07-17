package kg.infosystems.buhproject.security.infocom;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class InfocomService {
    public final String URL;

    private final RestTemplate restTemplate;

    public InfocomService(RestTemplateBuilder restTemplateBuilder, InfocomProperties infocomProperties) {
        restTemplate = restTemplateBuilder.build();
        restTemplate.setInterceptors(List.of((request, body, execution) -> {
            request.getHeaders().set("Content-Type", "application/json;charset=utf-8");
            request.getHeaders().set("User-Agent", infocomProperties.getAgent());
            request.getHeaders().set("Authorization", "Bearer " + infocomProperties.getToken());
            return execution.execute(request, body);
        }));
        URL = infocomProperties.getUrl();
    }

    public AuthMethodsResponse getAuthMethods(String user, String org) {
        String url = URL + "user-auth-methods";
        AuthMethodsRequest request = new AuthMethodsRequest(user, org);
        return call(url, request, AuthMethodsResponse.class);
    }

    public PincodeResponse getPincode(String user, String org, String method) {
        String url = URL + "get-pin-code";
        PincodeRequest request = new PincodeRequest(user, org, method);
        return call(url, request, PincodeResponse.class);
    }

    public AuthResponse getToken(String user, String org, String code) {
        String url = URL + "account/auth";
        AuthRequest request = new AuthRequest(user, org, code);
        return call(url, request, AuthResponse.class);
    }

    public CertInfoResponse getCertInfo(String token) {
        String url = URL + "get-cert-info";
        CertInfoRequest request = new CertInfoRequest(token);
        return call(url, request, CertInfoResponse.class);
    }

    public SignResponse getSignature(String hash, String token) {
        String url = URL + "get-sign/for-hash";
        SignRequest request = new SignRequest(hash, token);
        return call(url, request, SignResponse.class);
    }

    public CheckSignResponse checkSignature(String signature, String hash) {
        String url = URL + "check-sign/for-hash";
        CheckSignRequest request = new CheckSignRequest(signature, hash);
        return call(url, request, CheckSignResponse.class);
    }

    public String signContent(String user, String org, String code, String content) {
        AuthResponse authResponse = getToken(user, org, code);
        String token = authResponse.getToken();

        String hash = EncryptionUtil.encrypt(content);
        SignResponse signResponse = getSignature(hash, token);
        return signResponse.getSign();
    }

    public boolean verifyContent(String signature, String content) {
        String hash = EncryptionUtil.encrypt(content);
        CheckSignResponse checkSignResponse = checkSignature(signature, hash);
        return checkSignResponse.getVerified();
    }

    private <RES, REQ> RES call(String url, REQ req, Class<RES> res) {
        try {
            ResponseEntity<RES> responseEntity = restTemplate.postForEntity(url, req, res);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        } catch (RestClientException e) {
            throw new InfocomException(e.toString());
        }

        throw new InfocomException("Should not come here");
    }
}
