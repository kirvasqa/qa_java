package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private String sex;
    private boolean expectedHasMane;
    private Lion lion;
    private Feline mockFeline;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class); // Создаем мок Feline
        lion = new Lion(sex, mockFeline); // Передаем мок в конструктор
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}