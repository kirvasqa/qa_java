
package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    private Feline mockFeline;

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class);
    }

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Некорректное значение", mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion("Самец", mockFeline);
        List<String> expectedFood = Arrays.asList("Мясо", "Дичь");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}