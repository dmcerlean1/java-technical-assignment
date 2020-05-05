package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

/**
 * A discount calculator. Knows about all available discounts and the
 * items to which they apply.
 *
 * Alternatively I may have put the discounts in the items but I want to be able
 * to make discounts across different items.
 */
public class DiscountCalculator {

    private final Discount discount;

    public DiscountCalculator(){
        discount = new TwoForThePriceOfOne();
    }

    /**
     * Go through any discounts and apply them
     * @param items - the items to apply the discounts to
     * @return the total value of the discounts
     */
    public BigDecimal getDiscounts(List<Item> items) {
        return discount.apply(items);
    }
}
