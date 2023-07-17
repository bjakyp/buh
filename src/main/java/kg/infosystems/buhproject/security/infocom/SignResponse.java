package kg.infosystems.buhproject.security.infocom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignResponse {
    private Boolean isSuccesfull;
    private String sign;
    private Long timestamp;
    private String errorCode;
    private String errorMessage;

}
