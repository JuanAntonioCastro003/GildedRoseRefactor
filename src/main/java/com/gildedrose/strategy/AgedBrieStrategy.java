package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy extends AbstractStrategy
{

    @Override
    public void updateQuality(Item item) {
        incrementarQuality(item);
    }

    @Override
    public void updateExpiration(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void handleExpired(Item item) {
        incrementarQuality(item);

    }
}
