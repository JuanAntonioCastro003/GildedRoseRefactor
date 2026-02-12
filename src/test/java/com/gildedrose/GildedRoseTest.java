package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normal_article_decrease_one_quality_on_positive_sellIn() {
        Item[] items = new Item[]{
                new Item("Normal article", 5, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void normal_article_decrease_double_quality_on_zero_sellIn() {
        Item[] items = new Item[]{
                new Item("Normal article", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }


    @Test
    void normal_article_with_negative_sellIn_are_never_negative() {
        Item item = new Item("Normal article", 0, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
    }

}
