package kg.infosystems.buhproject.security.infocom;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
public class InfocomAuthToken extends AbstractAuthenticationToken {

    private final String user;
    private final String comp;
    private final String code;

    public InfocomAuthToken(String user, String comp, String code) {
        super(null);
        this.user = user;
        this.comp = comp;
        this.code = code;
    }

    @Override
    public Object getCredentials() {
        return code;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }
}
