package kata.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A discount calculator. Knows about all available discounts and the
 * items to which they apply.
 *

 */
public class DiscountCalculator {

    private final Map<String, Discount> discountsToApply;

    public DiscountCalculator(){
        discountsToApply = new HashMap<>();
        discountsToApply.put("Carrots", new TwoForThePriceOfOne());
    }

    /**
     * Go through any discounts and apply them
     * @param items - the items to apply the discounts to
     * @return the total value of the discounts
     */
    public BigDecimal getDiscounts(List<Item> items) {

        BigDecimal totalDiscount = new BigDecimal(0);
        // inefficient - time constraints
        for(Map.Entry<String, Discount> productDiscount : discountsToApply.entrySet()) {

            List<Item> applicableItems = items.stream()
                    .filter(i -> i.name().equals(productDiscount.getKey()))
                    .collect(Collectors.toList());
            BigDecimal currentDiscount = productDiscount.getValue().apply(applicableItems);
            totalDiscount = totalDiscount.add(currentDiscount);
        }
        return totalDiscount;
    }
}
