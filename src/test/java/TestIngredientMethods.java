import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredientMethods {
    private final int index;
    private final IngredientType type;
    private final String name;
    private final float price;

    public TestIngredientMethods(int index, IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {0, SAUCE, "hot sauce", 100},
                {1, SAUCE, "sour cream", 200},
                {2, SAUCE, "chili sauce", 300},
                {3, FILLING, "cutlet", 100},
                {4, FILLING, "dinosaur", 200},
                {5, FILLING, "sausage", 300},
        };
    }

    @Test
    public void testGetPriceIngredient() {
        Database database = new Database();
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();
        System.out.println(actualResult);
        assertEquals(database.availableIngredients().get(index).getPrice(), actualResult, 2);
    }

    @Test
    public void testGetNameIngredient() {
        Database database = new Database();
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualResult = ingredient.getName();
        System.out.println(actualResult);
        assertEquals(database.availableIngredients().get(index).getName(), actualResult);
    }

    @Test
    public void testGetTypeIngredient() {
        Database database = new Database();
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();
        System.out.println(actualResult);
        assertEquals(database.availableIngredients().get(index).getType(), actualResult);
    }
}