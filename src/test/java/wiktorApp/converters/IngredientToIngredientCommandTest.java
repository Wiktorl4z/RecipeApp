package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.IngredientCommand;
import wiktorApp.domain.Ingredient;
import wiktorApp.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    private static final Long TEST_ID = 1L;
    private static final String TEST_DESCRIPTION = "Description";
    private static final BigDecimal TEST_AMOUNT = new BigDecimal("5");
    public static final Long TEST_UOM_ID = new Long(2L);
    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() throws Exception {
        // given
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(TEST_ID);
        ingredient.setDescription(TEST_DESCRIPTION);
        ingredient.setAmount(TEST_AMOUNT);
        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(TEST_UOM_ID);
        ingredient.setUom(unitOfMeasure);

        // when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        // then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(TEST_ID, ingredientCommand.getId());
        assertEquals(TEST_DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(TEST_AMOUNT, ingredientCommand.getAmount());
        assertEquals(TEST_UOM_ID, ingredientCommand.getUom().getId());
    }
}