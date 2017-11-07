package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.CategoryCommand;
import wiktorApp.commands.IngredientCommand;
import wiktorApp.commands.NotesCommand;
import wiktorApp.commands.RecipeCommand;
import wiktorApp.domain.Difficulty;
import wiktorApp.domain.Recipe;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

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
    public static final Long CAT_ID2 = 2L;
    public static final Long INGRED_ID_1 = 3L;
    public static final Long INGRED_ID_2 = 4L;
    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new CategoryCommandToCategory(),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID_VALUE);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTION);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);
        recipeCommand.setNotes(notesCommand);
        recipeCommand.setUrl(URL);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setPrepTime(PREP_TIME);

        CategoryCommand category = new CategoryCommand();
        category.setId(CAT_ID_1);
        recipeCommand.getCategories().add(category);

        CategoryCommand category2 = new CategoryCommand();
        category2.setId(CAT_ID2);
        recipeCommand.getCategories().add(category2);

        IngredientCommand ingredient = new IngredientCommand();
        ingredient.setId(INGRED_ID_1);
        recipeCommand.getIngredients().add(ingredient);

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGRED_ID_2);
        recipeCommand.getIngredients().add(ingredient2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID_VALUE, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTION, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());

    }
}