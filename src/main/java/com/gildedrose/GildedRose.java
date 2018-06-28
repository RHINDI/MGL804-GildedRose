package com.gildedrose;

import com.gildedrose.categorys.Backstage;
import com.gildedrose.categorys.AgedBrie;
import com.gildedrose.categorys.Sulfuras;
import com.gildedrose.categorys.Conjured;

class GildedRose {
    Item[] items;
    private String AGED_BRIE = "Aged Brie";
    private String BACK_STAGE = "Backstage passes to a TAFKAL80ETC concert";
    private String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private String CONJURED = "Conjured";

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
        if (item.name.equals(SULFURAS)) {
            return new Sulfuras();
        }
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie();
        }
        if (item.name.equals(BACK_STAGE)) {
            return new Backstage();
        }
        if(item.name.equals(CONJURED)){
            return new Conjured();
        }
        return new ItemCategory();
    }



}