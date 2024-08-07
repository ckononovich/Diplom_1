import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredientMethods {

    private final IngredientType type;
    private final String name;
    private final float price;

    public TestIngredientMethods (IngredientType type, String name, float price){
        this.type= type;
        this.name=name;
        this.price=price;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
        };
    }

    @Test
    public void testGetPriceIngredient(){
        Ingredient ingredient =new Ingredient(type,name,price);
        float actualResult = ingredient.getPrice();
        assertEquals(ingredient.getPrice(), actualResult, 2);
    }
    @Test
    public void testGetNameIngredient(){
        Ingredient ingredient =new Ingredient(type,name,price);
        String actualResult = ingredient.getName();
        assertEquals(ingredient.getName(), actualResult);
    }
    @Test
    public void testGetTypeIngredient(){
        Ingredient ingredient =new Ingredient(type,name,price);
        IngredientType actualResult = ingredient.getType();
        assertEquals(ingredient.getType(), actualResult);
    }
}