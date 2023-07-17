package kg.infosystems.buhproject.security.infocom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthMethodsRequest {
    private String personIdnp;
    private String organizationInn;
}
