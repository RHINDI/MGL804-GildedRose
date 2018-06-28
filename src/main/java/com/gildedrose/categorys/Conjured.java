package com.gildedrose.categorys;

import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class Conjured extends ItemCategory{
    protected void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
    protected void updateQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
