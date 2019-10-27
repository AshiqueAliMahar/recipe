package ali.ashique.recipe.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandTest {
    Category category = new Category();
    int a, b;

    @Before
    public void set() {
        a = 10;
        b = 100;
    }

    @Test
    public void checkSum() {
        int add = add(a, b);
        assertEquals(110, add);
    }

    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void setId() {
        System.out.println("id");
    }

    @Test
    public void setCategoryName() {
    }
}