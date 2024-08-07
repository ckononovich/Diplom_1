import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGettingReceipt {

    @Spy
    Burger burger;

    @Test
    public void testGettingReceipt() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(5));
        burger.moveIngredient(2, 1);
        burger.removeIngredient(0);
        String actualResult = burger.getReceipt();
        System.out.println(actualResult);
        assertThat(actualResult, notNullValue());
    }
}