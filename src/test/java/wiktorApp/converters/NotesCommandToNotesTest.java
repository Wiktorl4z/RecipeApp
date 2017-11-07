package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.NotesCommand;
import wiktorApp.domain.Notes;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    private static final Long TEST_ID = 1L;
    private static final String TEST_RECIPE_NOTES = "Notes";
    NotesCommandToNotes convert;

    @Before
    public void setUp() throws Exception {
        convert = new NotesCommandToNotes();
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(convert.convert(new NotesCommand()));
    }

    @Test
    public void testNullConvert() {
        assertNull(convert.convert(null));
    }


    @Test
    public void convert() throws Exception {
        // given
        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(TEST_ID);
        notesCommand.setRecipeNotes(TEST_RECIPE_NOTES);

        // when
        Notes notes = convert.convert(notesCommand);

        // then
        assertNotNull(notes);
        assertEquals(TEST_ID, notes.getId());
        assertEquals(TEST_RECIPE_NOTES, notes.getRecipeNotes());
    }
}