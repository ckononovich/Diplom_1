import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGettingPrice {

    @Mock
    Ingredient ingredients;

    @Mock
    Bun bun;

    @Test
    public void testGettingPrice() {
        Burger burger = new Burger();
        Database database = new Database();
        Mockito.when(ingredients.getPrice()).thenReturn(Float.valueOf(200));
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100));
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        float expectedResult = ingredients.getPrice() + bun.getPrice() * 2;
        float actualResult = burger.getPrice();
        System.out.println(actualResult);
        assertEquals(expectedResult, actualResult, 2);
    }
}