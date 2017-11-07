package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.IngredientCommand;
import wiktorApp.commands.UnitOfMeasureCommand;
import wiktorApp.domain.Ingredient;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private static final Long TEST_ID = 1L;
    private static final String TEST_DESCRIPTION = "Description";
    private static final BigDecimal TEST_AMOUNT = new BigDecimal("5");
    public static final Long TEST_UOM_ID = new Long(2L);
    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        // given
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(TEST_ID);
        ingredientCommand.setDescription(TEST_DESCRIPTION);
        ingredientCommand.setAmount(TEST_AMOUNT);
        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(TEST_UOM_ID);
        ingredientCommand.setUnitOfMeasure(unitOfMeasureCommand);

        // when
        Ingredient ingredient = converter.convert(ingredientCommand);

        // then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(TEST_ID, ingredient.getId());
        assertEquals(TEST_DESCRIPTION, ingredient.getDescription());
        assertEquals(TEST_AMOUNT, ingredient.getAmount());
        assertEquals(TEST_UOM_ID, ingredient.getUom().getId());
    }
}