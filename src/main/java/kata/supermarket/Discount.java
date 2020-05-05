package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface for a discount.
 */
public interface Discount {

    BigDecimal apply(List<Item> items);
}
