package training.endava.app.division;

import org.junit.Test;
import training.endava.app.division.DivisionUtil;

import static org.junit.Assert.*;

public class DivisionUtilTest {


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSecondParameterIsZero() {
        DivisionUtil divisionUtil = new DivisionUtil();
        divisionUtil.divideWithException(1,0);
    }

    @Test
    public void shouldThrowExceptionWhenSecondParameterIsZeroWithCatch() {
        DivisionUtil divisionUtil = new DivisionUtil();
        try {
            divisionUtil.divideWithException(1, 0);
            // ** required to fail test
            fail("Should not get here");
        } catch (IllegalArgumentException iae){
            assertEquals("b cannot be 0", iae.getMessage());
        }
    }

    @Test
    public void shouldReturnNanWhenParameterIsZero() {
        DivisionUtil divisionUtil = new DivisionUtil();
        Double result = divisionUtil.divideWithNan(1, 0);

        assertTrue(Double.isNaN(result));
    }

}
