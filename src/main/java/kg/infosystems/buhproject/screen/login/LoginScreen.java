package kg.infosystems.buhproject.screen.login;

import io.jmix.core.MessageTools;
import io.jmix.core.Messages;
import io.jmix.securityui.authentication.AuthDetails;
import io.jmix.securityui.authentication.LoginScreenSupport;
import io.jmix.ui.JmixApp;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.*;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import io.jmix.ui.security.UiLoginProperties;
import kg.infosystems.buhproject.security.infocom.InfocomAuthToken;
import kg.infosystems.buhproject.security.infocom.Supp;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Locale;

@UiController("LoginScreen")
@UiDescriptor("login-screen.xml")
@Route(path = "login", root = true)
public class LoginScreen extends Screen {

    @Autowired
    private TextField<String> usernameField;

    @Autowired
    private PasswordField passwordField;

    @Autowired
    private CheckBox rememberMeCheckBox;

    @Autowired
    private ComboBox<Locale> localesField;

    @Autowired
    private Notifications notifications;

    @Autowired
    private Messages messages;

    @Autowired
    private MessageTools messageTools;

    //    @Autowired
    private LoginScreenSupport loginScreenSupport;

    @Autowired
    private UiLoginProperties loginProperties;

    @Autowired
    private JmixApp app;

    private final Logger log = LoggerFactory.getLogger(LoginScreen.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Supp supp;
    @Autowired
    private TextField<String> companyField;
    @Autowired
    private CheckBox infoCheckBox;
    @Autowired
    private Button loginButton;
    @Autowired
    private Button loginInfoButton;

    @Subscribe
    private void onInit(InitEvent event) {
        loginScreenSupport = supp;
        usernameField.focus();
        initLocalesField();
        initDefaultCredentials();
        toggleInfo(false);
    }

    private void initLocalesField() {
        localesField.setOptionsMap(messageTools.getAvailableLocalesMap());
        localesField.setValue(app.getLocale());
        localesField.addValueChangeListener(this::onLocalesFieldValueChangeEvent);
    }

    private void onLocalesFieldValueChangeEvent(HasValue.ValueChangeEvent<Locale> event) {
        //noinspection ConstantConditions
        app.setLocale(event.getValue());
        UiControllerUtils.getScreenContext(this).getScreens()
            .create(this.getClass(), OpenMode.ROOT)
            .show();
    }

    private void initDefaultCredentials() {
        //String defaultUsername = loginProperties.getDefaultUsername();
        String defaultUsername = "";
        if (!StringUtils.isBlank(defaultUsername) && !"<disabled>".equals(defaultUsername)) {
            usernameField.setValue(defaultUsername);
        } else {
            usernameField.setValue("");
        }

//        String defaultPassword = loginProperties.getDefaultPassword();
        String defaultPassword = "";
        if (!StringUtils.isBlank(defaultPassword) && !"<disabled>".equals(defaultPassword)) {
            passwordField.setValue(defaultPassword);
        } else {
            passwordField.setValue("");
        }
    }

    @Subscribe("submit")
    private void onSubmitActionPerformed(Action.ActionPerformedEvent event) {
        login();
    }

    private void login() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            notifications.create(Notifications.NotificationType.WARNING)
                .withCaption(messages.getMessage(getClass(), "emptyUsernameOrPassword"))
                .show();
            return;
        }

        try {
            loginScreenSupport.authenticate(
                AuthDetails.of(username, password)
                    .withLocale(localesField.getValue())
                    .withRememberMe(rememberMeCheckBox.isChecked()), this);
        } catch (BadCredentialsException | DisabledException | LockedException e) {
            log.warn("Login failed for user '{}': {}", username, e.toString());
            notifications.create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(getClass(), "loginFailed"))
                .withDescription(messages.getMessage(getClass(), "badCredentials"))
                .show();
        }
    }

    private void toggleInfo(Boolean val) {
        companyField.setVisible(val);
        loginInfoButton.setVisible(val);

        rememberMeCheckBox.setVisible(!val);
        loginButton.setVisible(!val);
    }

    @Subscribe("submitInfo")
    public void onSubmitInfo(Action.ActionPerformedEvent event) {
        loginInfo();
    }

    private void loginInfo() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();
        String company = companyField.getValue();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(company)) {
            notifications.create(Notifications.NotificationType.WARNING)
                .withCaption(messages.getMessage(getClass(), "emptyUsernameOrPassword"))
                .show();
            return;
        }

        try {
            InfocomAuthToken token = new InfocomAuthToken(username, company, password);

            Authentication authenticationToken = authenticationManager.authenticate(token);

            supp.onSuccessfulAuthentication(authenticationToken, AuthDetails.of(username, password), this);

        } catch (BadCredentialsException | DisabledException | LockedException e) {
            log.warn("Login failed for user '{}': {}", username, e.toString());
            notifications.create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(getClass(), "loginFailed"))
                .withDescription(messages.getMessage(getClass(), "badCredentials"))
                .show();
        } catch (AuthenticationServiceException e) {
            notifications.create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMessage(getClass(), "loginFailed"))
                .withDescription(e.getCause().getMessage())
                .show();
        }
    }

    @Subscribe("infoCheckBox")
    public void onInfoCheckBoxValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        toggleInfo(event.getValue());
    }

}
