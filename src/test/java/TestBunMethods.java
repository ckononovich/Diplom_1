import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBunMethods {

    private final String bunName;
    private final float bunPrice;

    public TestBunMethods(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunNameAndPrice() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void bunNameIsDisplayed() {
        Bun bun = new Bun(bunName, bunPrice);
        String actualResult = bun.getName();
        System.out.println(actualResult);
        assertEquals(bun.getName(), actualResult);
    }

    @Test
    public void bunPriceIsDisplayed() {
        Bun bun = new Bun(bunName, bunPrice);
        float actualResult = bun.getPrice();
        System.out.println(actualResult);
        assertEquals(bun.getPrice(), actualResult, 2);
    }
}