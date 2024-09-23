import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBunMethods {
    private final int bunIndex;
    private final String bunName;
    private final float bunPrice;

    public TestBunMethods(int bunIndex, String bunName, float bunPrice) {
        this.bunIndex = bunIndex;
        this.bunName = bunName;
        this.bunPrice = bunPrice;

    }

    @Parameterized.Parameters
    public static Object[][] getBunNameAndPrice() {
        return new Object[][]{
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300},
        };
    }

    @Test
    public void bunNameIsDisplayed() {
        Database database = new Database();
        Bun bun = new Bun(bunName, bunPrice);
        String actualResult = bun.getName();
        System.out.println(actualResult);
        assertEquals(database.availableBuns().get(bunIndex).getName(), actualResult);
    }

    @Test
    public void bunPriceIsDisplayed() {
        Database database = new Database();
        Bun bun = new Bun(bunName, bunPrice);
        float actualResult = bun.getPrice();
        System.out.println(actualResult);
        assertEquals(database.availableBuns().get(bunIndex).getPrice(), actualResult, 2);
    }
}