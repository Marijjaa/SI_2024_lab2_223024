package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class SILab2Test {

    @BeforeAll
    static void init(){
        System.out.println("Testing begin");
    }


    @Test
    void checkCartEveryBranch() {
        System.out.println("Testing Every Branch - 5 Test Cases");

        RuntimeException ex1;
        ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 500));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        Item[] list1 = new Item[]{ new Item(null,"0123",500,0.7f), new Item("i1","1234",50,0), new Item("i2",null,70,0) };
        List<Item> items1 = Arrays.stream(list1).toList();
        RuntimeException ex2;
        ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1,500));
        assertTrue(ex2.getMessage().contains("No barcode!"));

        Item[] list2 = new Item[]{ new Item("i1","@245", 100, 0)};
        List<Item> items2 = Arrays.stream(list2).toList();
        RuntimeException ex3;
        ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2,500));
        assertTrue(ex3.getMessage().contains("Invalid character in item barcode!"));

        Item[] list3 = new Item[]{ new Item("i1","0123", 500, 0.7f)};
        List<Item> items3 = Arrays.stream(list3).toList();
        assertTrue(SILab2.checkCart(items3,600));

        Item[] list4 = new Item[]{ new Item("i1","0123", 500, 0.7f)};
        List<Item> items4 = Arrays.stream(list4).toList();
        assertFalse(SILab2.checkCart(items4,200));
    }

    @Test
    void checkCartMultipleCondition(){
        System.out.println("Testing Multiple Condition - 4 Test Cases");

        //TTT
        Item[] list1 = new Item[]{ new Item("i1","0123", 500, 0.7f)};
        List<Item> items1 = Arrays.stream(list1).toList();
        assertTrue(items1.getFirst().getPrice()>300);
        assertTrue(items1.getFirst().getDiscount()>0);
        assertEquals('0', items1.getFirst().getBarcode().charAt(0));

        //TTF
        Item[] list2 = new Item[]{ new Item("i2", "1234", 500, 0.7f)};
        List<Item> items2 = Arrays.stream(list2).toList();
        assertTrue(items2.getFirst().getPrice()>300);
        assertTrue(items2.getFirst().getDiscount()>0);
        assertFalse(items2.getFirst().getBarcode().charAt(0)=='0');

        //TFX
        Item[] list3 = new Item[]{ new Item("i3", "0123", 500, 0.0f)};
        List<Item> items3 = Arrays.stream(list3).toList();
        assertTrue(items3.getFirst().getPrice()>300);
        assertFalse(items3.getFirst().getDiscount()>0);

        //FXX
        Item[] list4 = new Item[]{ new Item("i4", "0123", 100, 0.7f)};
        List<Item> items4 = Arrays.stream(list4).toList();
        assertFalse(items4.getFirst().getPrice()>300);

    }

    @AfterAll
    static void destroy(){
        System.out.println("Testing end");
    }
}