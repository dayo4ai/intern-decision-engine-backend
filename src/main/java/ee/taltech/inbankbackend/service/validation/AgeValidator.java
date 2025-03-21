package ee.taltech.inbankbackend.service.validation;

public interface AgeValidator {
    ValidationResponse validateAge(String personalCode);
    String getCountryCode();
}

public class BalticAgeValidator implements AgeValidator {
    private static final int MINIMUM_AGE = 18;
    private static final Map<String, Integer> COUNTRY_LIFE_EXPECTANCY = Map.of(
        "EE", 78,
        "LV", 75,
        "LT", 76
    );
    
    @Override
    public boolean isValidAge(String personalCode) {
        int age = calculateAge(personalCode);
        String country = determineCountry(personalCode);
        int maxAge = COUNTRY_LIFE_EXPECTANCY.get(country) - DecisionEngineConstants.MAXIMUM_LOAN_PERIOD/12;
        
        return age >= MINIMUM_AGE && age <= maxAge;
    }
}