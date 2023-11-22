package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementsListTest {
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer thirdNumber;
    private Integer fourthNumber;
    private Integer fifthNumber;
    private Integer nullNumber;
    ElementListServiceImpl out = new ElementListServiceImpl();
    @BeforeEach
    public void setup() {
        firstNumber = 1;
        secondNumber = 2;
        thirdNumber = 3;
        fourthNumber = 4;
        fifthNumber = 5;
        nullNumber = null;
        out.add(firstNumber);
        out.add(secondNumber);
        out.add(thirdNumber);
        out.add(fourthNumber);
        out.add(fifthNumber);
    }

    @Test
    void add() {
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5};
        Integer[] actual = out.toArray();
        assertArrayEquals(actual, expected);
    }

    @Test
    void addNotNull() {
        Integer[] expected = out.toArray();
        assertNotNull(expected);
    }
    @Test
    void addNull() {
        Assertions.assertThrows(NullPointerException.class,()-> out.add(nullNumber));
    }

    @Test
    void addTest() {
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5};
        Integer[] actual = out.toArray();
        assertArrayEquals(actual, expected);
    }

    @Test
    void set() {
        out.set(0,10);
        Integer[] expected = new Integer[]{10, 2, 3, 4, 5};
        Integer[] actual = out.toArray();
        assertArrayEquals(actual, expected);
    }

    @Test
    void remove() {
        out.remove(5);
        Integer[] expected = new Integer[]{1, 2, 3, 4};
        Integer[] actual = out.toArray();
        assertArrayEquals(actual, expected);
    }

    @Test
    void removeByIndex() {
        out.removeByIndex(0);
        Integer[] expected = new Integer[]{2, 3, 4, 5};
        Integer[] actual = out.toArray();
        assertArrayEquals(actual, expected);
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}