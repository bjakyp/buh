package kg.infosystems.buhproject.security.infocom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PincodeRequest {
    private String personIdnp;
    private String organizationInn;
    private String method;
}
