package com.gildedrose;

import com.gildedrose.strategy.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyUpdate() {
        for (Item item : items) {

            AbstractStrategy strategy = switch(item.name){
                case "Aged Brie" -> new AgedBrieStrategy();
                case "Backstage passes to a TAFKAL80ETC concert" -> new ConcertStrategy();
                case "Sulfuras, Hand of Ragnaros" -> new SulfurasStrategy();
                default -> new DefaultStrategy();
            };

        }
    }
}
