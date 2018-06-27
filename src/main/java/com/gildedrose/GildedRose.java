package com.gildedrose;

class GildedRose {
    Item[] items;
    boolean isAgedBrie, isConcert, isSulfuras;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            isAgedBrie = item.name.equals("Aged Brie");
            isConcert = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            updateOneItem(item);
        }
    }

    private void updateOneItem(Item item) {
        updateQuality(item);

        updateSellIn(item);

        if (hasExpired(item)) {
            updateExpired(item);
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void updateExpired(Item item) {
        if (isAgedBrie) {
            incrementQuality(item);
        } else if (isConcert) {
            item.quality = 0;
        } else if (isSulfuras) {
        } else {
            decrementQuality(item);
        }
    }

    private void updateQuality(Item item) {
        if (isAgedBrie) {
            incrementQuality(item);
        } else if (isConcert) {
            incrementQuality(item);
            if (item.sellIn < 11) {
                incrementQuality(item);
            }
            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else if (isSulfuras) {
        } else {
            decrementQuality(item);
        }
    }


    private void updateSellIn(Item item) {
        if (!isSulfuras) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}