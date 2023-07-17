package kg.infosystems.buhproject.security.infocom;

import lombok.Data;

@Data
public class AuthResponse {
    private String createAt;
    private String expireAt;
    private Integer subjectType;
    private String personIdnp;
    private String personFio;
    private String organizationInn;
    private String organizationName;
    private Boolean isActive;
    private String token;

    private Integer errorCode;
    private String errorMessage;
}
