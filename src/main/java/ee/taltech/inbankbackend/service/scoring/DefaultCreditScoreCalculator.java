package ee.taltech.inbankbackend.service.scoring;

public class DefaultCreditScoreCalculator implements CreditScoreCalculator {
    @Override
    public double calculateScore(int creditModifier, long loanAmount, int loanPeriod) {
        return ((double) creditModifier / loanAmount * loanPeriod) / 10;
    }
}