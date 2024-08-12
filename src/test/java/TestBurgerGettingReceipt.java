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
public class TestBurgerGettingReceipt {

    @Mock
    Ingredient ingredients;

    @Mock
    Ingredient ingredientOneMore;

    @Mock
    Bun bun;

    @Test
    public void testGettingReceipt() {
        Burger burger = new Burger();
        Database database = new Database();
        Mockito.when(bun.getName()).thenReturn(String.format("(==== black bun ====)%n"));
        Mockito.when(ingredients.getName()).thenReturn(String.format("= sauce hot sauce =%n"));
        Mockito.when(ingredientOneMore.getName()).thenReturn(String.format("= sauce sour cream =%n"));
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        String actualResult = burger.getReceipt();
        float price = burger.getPrice();
        String expectedResult = bun.getName() + ingredients.getName() + ingredientOneMore.getName() + bun.getName() + String.format("%nPrice: %f%n", price);
        System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
    }
}