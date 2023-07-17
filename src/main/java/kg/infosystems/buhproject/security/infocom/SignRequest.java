package kg.infosystems.buhproject.security.infocom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignRequest {
    private String hash;
    private String userToken;
}
