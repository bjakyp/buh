package kg.infosystems.buhproject.security.infocom;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("oep.config")
@Data
public class InfocomProperties {
    private String url = "https://cdsapi.srs.kg/api/";
    private String agent = "minfin";
    private String token = "NiDqEoSRmFKyEPf0u3po4rDjowfxggmV";
}
