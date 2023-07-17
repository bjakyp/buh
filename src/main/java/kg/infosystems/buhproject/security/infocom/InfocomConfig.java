package kg.infosystems.buhproject.security.infocom;

import io.jmix.security.StandardSecurityConfiguration;
import io.jmix.security.impl.StandardAuthenticationProvidersProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;

@Configuration
@ComponentScan("kg.infosystems.buhproject")
@EnableConfigurationProperties(InfocomProperties.class)
public class InfocomConfig {
    @EnableWebSecurity
    public static class MyConf extends StandardSecurityConfiguration {
        @Autowired
        private InfocomProvider infocomProvider;

        @Override
        public AuthenticationManager authenticationManager(StandardAuthenticationProvidersProducer providersProducer, AuthenticationEventPublisher authenticationEventPublisher) {
            List<AuthenticationProvider> providers = providersProducer.getStandardProviders();
            providers.add(infocomProvider);
            ProviderManager providerManager = new ProviderManager(providers);
            providerManager.setAuthenticationEventPublisher(authenticationEventPublisher);
            return providerManager;
        }
    }

    @Bean
    Supp supp() {
        return new Supp();
    }
}
