package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
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
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isConcert = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

        if (!isAgedBrie) {
            if (!isConcert) {
                if (item.quality > 0) {
                    if (!isSulfuras) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            incrementQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item) {
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isConcert = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

        if ( isAgedBrie || isConcert) {
            updateCheeseOrPass(item);
        } else if (!isSulfuras && item.quality > 0) {
                item.quality = item.quality - 1;
        }
    }

    private void updateCheeseOrPass(Item item) {
        boolean isConcert = item.name.equals("Backstage passes to a TAFKAL80ETC concert");

        incrementQuality(item);
        if (isConcert) {
                if (item.sellIn < 11) {
                    incrementQuality(item);
                }

                if (item.sellIn < 6) {
                    incrementQuality(item);
                }
            }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}