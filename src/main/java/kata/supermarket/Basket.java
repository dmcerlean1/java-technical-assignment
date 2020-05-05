package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;
    private final DiscountCalculator discountCalculator;

    public Basket() {
        this.items = new ArrayList<>();
        this.discountCalculator = new DiscountCalculator();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Get total of discounts that apply to my basket
     * @return total value of discounts
     */
    public BigDecimal discounts() {
        return discountCalculator.getDiscounts(items());
    }

    public BigDecimal total() {
        return new TotalCalculator(discounts()).calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;
        private final BigDecimal discounts;

        TotalCalculator(BigDecimal discounts) {
            this.items = items();
            this.discounts = discounts;
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
            return discounts;
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
