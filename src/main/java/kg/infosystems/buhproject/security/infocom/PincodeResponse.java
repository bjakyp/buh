package kg.infosystems.buhproject.security.infocom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PincodeResponse {
    private String status;
    private String errorCode;
    private String errorMessage;
}
