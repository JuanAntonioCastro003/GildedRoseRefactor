package com.gildedrose.strategy;

import com.gildedrose.Item;

public abstract class AbstractStrategy
{
    abstract public void updateQuality(Item item);
    abstract  public void updateExpiration(Item item);
    abstract public void handleExpired(Item item);

    static void incrementarQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
