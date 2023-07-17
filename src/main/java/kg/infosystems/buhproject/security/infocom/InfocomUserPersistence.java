package kg.infosystems.buhproject.security.infocom;

import io.jmix.core.DataManager;
import io.jmix.core.security.Authenticated;
import kg.infosystems.buhproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfocomUserPersistence {
    @Autowired
    private DataManager dataManager;

    @Authenticated
    public User loadUserByPin(String pin, String fio) {
        return dataManager.load(User.class)
            .query("select u from User u where u.username = :pin")
            .parameter("pin", pin)
            .optional()
            .orElseThrow();
    }
}
