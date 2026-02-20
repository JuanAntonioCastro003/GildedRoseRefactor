package com.gildedrose.strategy;

import com.gildedrose.Item;

public class DefaultStrategy extends AbstractStrategy{
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0)
        {
                item.quality = item.quality - 1;
        }
    }

    @Override
    public void updateExpiration(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void handleExpired(Item item) {
        item.quality = item.quality - 1;
    }
}
