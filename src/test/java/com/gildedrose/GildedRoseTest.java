package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GildedRoseTest {
    final String expected = "OMGHAI!\n"+
            "-------- day 0 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 10, 20\n"+
            "Aged Brie, 2, 0\n"+
            "Elixir of the Mongoose, 5, 7\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n"+
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n"+
            "Conjured Mana Cake, 3, 6\n"+
            "\n"+
            "-------- day 1 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 9, 19\n"+
            "Aged Brie, 1, 1\n"+
            "Elixir of the Mongoose, 4, 6\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n"+
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n"+
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n"+
            "Conjured Mana Cake, 2, 5\n" +
            "\n" +
            "-------- day 2 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 8, 18\n" +
            "Aged Brie, 0, 2\n" +
            "Elixir of the Mongoose, 3, 5\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 13, 22\n" +
            "Backstage passes to a TAFKAL80ETC concert, 8, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 3, 50\n" +
            "Conjured Mana Cake, 1, 4\n" +
            "\n";

    @Test
    public void gildedRose(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;


        for (int i = 0; i < days; i++) {
            out.println("-------- day " + i + " --------");
            out.println("name, sellIn, quality");
            for (Item item : items) {
                out.println(item);
            }
            out.println();
            app.updateQuality();
        }
        System.out.println(output.toString());
        assertEquals(expected, output.toString());
    }


}
