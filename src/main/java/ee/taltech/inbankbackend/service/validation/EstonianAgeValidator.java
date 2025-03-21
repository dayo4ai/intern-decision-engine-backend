package ee.taltech.inbankbackend.service.validation;

import com.github.vladislavgoltjajev.java.personal.code.EstonianPersonalCodeValidator;
import com.github.vladislavgoltjajev.java.personal.code.EstonianPersonalCodeParser;
import java.time.Period;

public class EstonianAgeValidator implements AgeValidator {
    private static final int MINIMUM_AGE = 18;
    private static final int ESTONIA_LIFE_EXPECTANCY = 78;
    private final EstonianPersonalCodeValidator validator;
    private final EstonianPersonalCodeParser parser;

    public EstonianAgeValidator() {
        this.validator = new EstonianPersonalCodeValidator();
        this.parser = new EstonianPersonalCodeParser();
    }

    @Override
    public boolean isValidAge(String personalCode) {
        if (!validator.isValid(personalCode)) {
            return false;
        }

        Period agePeriod = parser.getAge(personalCode);
        int age = agePeriod.getYears();
        int maxAge = ESTONIA_LIFE_EXPECTANCY - DecisionEngineConstants.MAXIMUM_LOAN_PERIOD/12;

        return age >= MINIMUM_AGE && age <= maxAge;
    }

    @Override
    public ValidationResponse validateAge(String personalCode) {
        if (!validator.isValid(personalCode)) {
            return new ValidationResponse(false, ErrorMessages.INVALID_PERSONAL_CODE, "EE");
        }
        
        Period agePeriod = parser.getAge(personalCode);
        int age = agePeriod.getYears();
        
        if (age < balticProperties.getMinimumAge()) {
            return new ValidationResponse(false, ErrorMessages.UNDERAGE, "EE");
        }
        
        int maxAge = balticProperties.getLifeExpectancy().get("EE") - 
                     balticProperties.getLoan().getMaxPeriod()/12;
                     
        if (age > maxAge) {
            return new ValidationResponse(false, ErrorMessages.OVER_AGE, "EE");
        }
        
        return new ValidationResponse(true, null, "EE");
    }

    @Override
    public String getCountryCode() {
        return "EE";
    }
}