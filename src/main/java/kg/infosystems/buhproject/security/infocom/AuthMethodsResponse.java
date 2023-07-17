package kg.infosystems.buhproject.security.infocom;

import lombok.Data;

import java.util.List;

@Data
public class AuthMethodsResponse {
    private List<AuthMethods> userAuthMethodList;

    private Boolean isActive;
    private String inactiveReason;
    private Integer errorCode;
    private String errorMessage;

    @Data
    static class AuthMethods {
        private String createAt;
        private String authType;
    }
}
