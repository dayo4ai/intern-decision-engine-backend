package ee.taltech.inbankbackend.model;
@Getter
@AllArgsConstructor
public class ValidationResponse {
    private final boolean valid;
    private final String message;
    private final String countryCode;
}