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

    @Test
    void quality_muts_never_be_negative() {
        Item item = new Item("Normal article", 10, 0);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);

    }

    @Test
    void test_for_aged_brie() {
        Item item = new Item("Aged Brie", 10, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
        assertEquals(9, items[0].sellIn);

    }

    @Test
    void test_for_expired_aged_brie() {
        Item item = new Item("Aged Brie", 0, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
        assertEquals(-1, items[0].sellIn);

    }

    @Test
    void quality_must_never_be_over_50() {
        Item item = new Item("Aged Brie", 0, 49);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
        assertEquals(-1, items[0].sellIn);

    }

    @Test
    void sulfura_never_decrease_quality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, items[0].quality);
        assertEquals(10, items[0].sellIn);
    }

    @Test
    void concert_in_normal_case() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, items[0].quality);
        assertEquals(14, items[0].sellIn);
    }

    @Test
    void concert_in_10_days_case() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void concert_in_5_days_case() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    void concert_over() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

}
