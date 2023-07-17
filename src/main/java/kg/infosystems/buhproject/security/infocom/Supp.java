package kg.infosystems.buhproject.security.infocom;

import io.jmix.securityui.authentication.AuthDetails;
import io.jmix.securityui.authentication.LoginScreenSupport;
import io.jmix.ui.screen.FrameOwner;
import org.springframework.security.core.Authentication;

import javax.annotation.Nullable;

public class Supp extends LoginScreenSupport {
    @Override
    public void onSuccessfulAuthentication(Authentication authentication, AuthDetails authDetails, @Nullable FrameOwner frameOwner) {
        super.onSuccessfulAuthentication(authentication, authDetails, frameOwner);
    }
}
