package wiktorApp.converters;

import org.junit.Before;
import org.junit.Test;
import wiktorApp.commands.UnitOfMeasureCommand;
import wiktorApp.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long TEST_ID = new Long(1L);
    UnitOfMeasureCommandToUnitOfMeasure convert;

    @Before
    public void setUp() throws Exception {
        convert = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(convert.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convert.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {

        // given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(TEST_ID);
        unitOfMeasureCommand.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure unit = convert.convert(unitOfMeasureCommand);

        // then
        assertNotNull(unit);
        assertEquals(TEST_ID, unit.getId());
        assertEquals(DESCRIPTION, unit.getDescription());
    }
}