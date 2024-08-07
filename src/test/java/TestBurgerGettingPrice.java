import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGettingPrice {

    @Spy
    Burger burger;

    @Test
    public void testGettingPrice() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        float actualResult = burger.getPrice();
        assertEquals(600, actualResult, 2);
    }
}