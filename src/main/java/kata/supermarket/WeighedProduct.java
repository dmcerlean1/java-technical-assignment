package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;
    private final String name;

    public WeighedProduct(final BigDecimal pricePerKilo, String name) {
        this.pricePerKilo = pricePerKilo;
        this.name = name;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public String getName() {
        return name;
    }
}
