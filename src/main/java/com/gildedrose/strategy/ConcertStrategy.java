package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConcertStrategy extends AbstractStrategy{
    @Override
    public void updateQuality(Item item) {

            incrementarQuality(item);

            if (item.sellIn < 11) {
                incrementarQuality(item);
            }

            if (item.sellIn < 6) {
                incrementarQuality(item);
            }
    }

    @Override
    public void updateExpiration(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void handleExpired(Item item) {
        item.quality = item.quality - item.quality;
    }
}
