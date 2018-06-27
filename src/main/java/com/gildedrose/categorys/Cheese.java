package com.gildedrose.categorys;

import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class Cheese extends ItemCategory {

    protected void updateExpired(Item item) {
        incrementQuality(item);
    }

    protected void updateQuality(Item item) {
        incrementQuality(item);
    }
}
