package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.RecipeCommand;
import wiktorApp.domain.*;

import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "Description";
    public static final Integer COOK_TIME = 5;
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final String DIRECTION = "Direction";
    public static final String URL = "www.google.com";
    public static final Integer SERVINGS = 4;
    public static final String SOURCE = "www.google1.com";
    public static final Integer PREP_TIME = 5;
    public static final Long NOTES_ID = 9L;
    public static final Long CAT_ID_1 = 1L;
    public static final Long CAT_ID_2 = 2L;
    public static final Long INGRED_ID_1 = 3L;
    public static final Long INGRED_ID_2 = 4L;
    RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(), new IngredientToIngredientCommand(new
                UnitOfMeasureToUnitOfMeasureCommand()), new NotesToNotesCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    public void convert() throws Exception {

        final Recipe recipe = new Recipe();
        recipe.setId(ID_VALUE);
        recipe.setDescription(DESCRIPTION);
        recipe.setCookTime(COOK_TIME);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTION);
        recipe.setUrl(URL);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setPrepTime(PREP_TIME);

        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);

        Category category = new Category();
        category.setId(CAT_ID_1);
        recipe.getCategories().add(category);

        Category category2 = new Category();
        category2.setId(CAT_ID_2);
        recipe.getCategories().add(category2);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGRED_ID_1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGRED_ID_2);

        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient2);

        RecipeCommand recipeCommand = converter.convert(recipe);

        assertNotNull(recipeCommand);
        assertEquals(ID_VALUE, recipeCommand.getId());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(COOK_TIME, recipeCommand.getCookTime());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(DIRECTION, recipeCommand.getDirections());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(NOTES_ID, recipeCommand.getNotes().getId());
        assertEquals(2, recipeCommand.getCategories().size());
        assertEquals(2, recipeCommand.getIngredients().size());

    }
}