package ee.taltech.inbankbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "baltic")
@Getter
@Setter
public class BalticProperties {
    private Map<String, Integer> lifeExpectancy;
    private int minimumAge;
    private Loan loan;

    @Getter
    @Setter
    public static class Loan {
        private int maxPeriod;
    }
}