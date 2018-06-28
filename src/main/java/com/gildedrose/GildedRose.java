package com.gildedrose;

import com.gildedrose.categorys.Backstage;
import com.gildedrose.categorys.AgedBrie;
import com.gildedrose.categorys.Sulfuras;
import com.gildedrose.categorys.Conjured;

class GildedRose {
    Item[] items;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACK_STAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

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
        switch (item.name){
            case AGED_BRIE: return new AgedBrie();
            case BACK_STAGE: return new Backstage();
            case SULFURAS : return new Sulfuras();
            case CONJURED : return new Conjured();
            default: return new ItemCategory();

        }
    }
}