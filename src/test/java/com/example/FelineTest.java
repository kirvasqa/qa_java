package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Animal mockAnimal = mock(Animal.class);
        when(mockAnimal.getFood("Хищник")).thenReturn(Arrays.asList("Мясо", "Рыба"));


        Feline feline = new Feline() {
            @Override
            public List<String> getFood(String type) throws Exception {
                return mockAnimal.getFood(type);
            }
        };


        assertEquals(Arrays.asList("Мясо", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}