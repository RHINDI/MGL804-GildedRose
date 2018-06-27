package com.gildedrose.categorys;

import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class Backstage extends ItemCategory {

    protected void updateExpired(Item item) {
        item.quality = 0;
    }
    protected void updateQuality(Item item) {
        incrementQuality(item);
        if(item.sellIn <= 10){
            incrementQuality(item);
        }
        if(item.sellIn <= 5){
            incrementQuality(item);
        }
    }
}
