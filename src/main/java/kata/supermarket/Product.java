package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;
    private final String name;

    public Product(final BigDecimal pricePerUnit, String name) {
        this.pricePerUnit = pricePerUnit;
        this.name = name;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public String getName() {
        return name;
    }
}
