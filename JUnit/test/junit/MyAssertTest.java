package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {

    List<String> todos= Arrays.asList("JavaScript","HTML","Spring");

    @Test
    void test()
    {
        boolean test=todos.contains("JavaScript");
        boolean test2=todos.contains("Reaact");

        //assertEquals(true,test);
        assertEquals(3,todos.size());
        assertTrue(test);
        assertFalse(test2);
        //assertNull,assertNotNull

        assertArrayEquals(new int[] {1,2}, new int[]{2});
    }
}