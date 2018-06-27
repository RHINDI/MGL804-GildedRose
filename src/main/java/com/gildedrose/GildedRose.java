package com.gildedrose;

import com.gildedrose.categorys.Backstage;
import com.gildedrose.categorys.Cheese;
import com.gildedrose.categorys.Legendary;

class GildedRose {
    Item[] items;
    String AgedBrie = "Aged Brie";
    String Backstage = "Backstage passes to a TAFKAL80ETC concert";
    String Sulfuras = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory category = categorize(item);
            category.updateOneItem(item);
        }
    }

    private ItemCategory categorize(Item item) {
        if (item.name.equals(Sulfuras)) {
            return new Legendary();
        }
        if (item.name.equals(AgedBrie)) {
            return new Cheese();
        }
        if (item.name.equals(Backstage)) {
            return new Backstage();
        }
        return new ItemCategory();
    }



}