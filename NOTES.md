# Notes
 Discount Calculator - Alternatively I may have put the discounts in the Items class however I wanted to be able
 to make discounts across different items.
 
 I assumed that each discount could be applicable across product types. One way of implementing this would be
 to extend the Discount interface with new methods for different item types.
 
 Due to time I'm missing Item type e.g. vegetables. This belongs in the Product class. My next commit, if I had time, 
 would be to add this in. I could then extend the DiscountCalculator with conditional logic 
 to apply discounts based on either type, name, or type and name.
 
 I included only one discount TwoForThePriceOfOne. A quick improvement here would be XForThePriceOfY.
 