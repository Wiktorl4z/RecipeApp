package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.NotesCommand;
import wiktorApp.domain.Notes;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    private static final Long TEST_ID = 1L;
    private static final String TEST_RECIPE_NOTES = "Notes";
    NotesToNotesCommand convert;

    @Before
    public void setUp() throws Exception {
        convert = new NotesToNotesCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(convert.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convert.convert(new Notes()));
    }

    @Test
    public void convert() throws Exception {
        // given
        final Notes notes = new Notes();
        notes.setId(TEST_ID);
        notes.setRecipeNotes(TEST_RECIPE_NOTES);

        // when
        NotesCommand notesCommand = convert.convert(notes);

        // then
        assertNotNull(notesCommand);
        assertEquals(TEST_ID, notesCommand.getId());
        assertEquals(TEST_RECIPE_NOTES, notesCommand.getRecipeNotes());
    }
}