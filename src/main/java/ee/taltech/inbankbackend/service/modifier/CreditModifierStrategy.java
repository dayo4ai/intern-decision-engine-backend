package ee.taltech.inbankbackend.service.modifier;

public interface CreditModifierStrategy {
    int getCreditModifier(String personalCode);
}

public class DefaultCreditModifierStrategy implements CreditModifierStrategy {
    @Override
    public int getCreditModifier(String personalCode) {
        int segment = Integer.parseInt(personalCode.substring(personalCode.length() - 4));
        if (segment < 2500) return 0;
        if (segment < 5000) return 100;
        if (segment < 7500) return 300;
        return 1000;
    }
}