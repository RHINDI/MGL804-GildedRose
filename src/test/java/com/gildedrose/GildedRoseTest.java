package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GildedRoseTest {
    @Test
    public void gildedRose(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
    }


    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
