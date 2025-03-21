package ee.taltech.inbankbackend.service.validation;

public class AgeValidatorFactory {
    public AgeValidator getValidator(String countryCode) {
        return switch (countryCode.toUpperCase()) {
            case "EE" -> new EstonianAgeValidator();
            case "LV" -> throw new UnsupportedOperationException("Latvian validation not yet implemented");
            case "LT" -> throw new UnsupportedOperationException("Lithuanian validation not yet implemented");
            default -> throw new IllegalArgumentException("Unsupported country code: " + countryCode);
        };
    }
}