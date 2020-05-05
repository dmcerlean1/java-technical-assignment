package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class TwoForThePriceOfOne implements Discount {

    private static final BigDecimal divideByTwo = new BigDecimal(2);

    @Override
    public BigDecimal apply(List<Item> items) {
        int totalInDiscount = items.size() / divideByTwo.intValue();
        int toSkip = totalInDiscount - items.size();
        return items.stream()
                .skip(toSkip)
                .filter(i -> i instanceof ItemByUnit)
                .map(Item::price)
                .reduce(BigDecimal::add)
                .map(total -> total.divide(divideByTwo))
                .orElse(BigDecimal.ZERO);
    }
}
