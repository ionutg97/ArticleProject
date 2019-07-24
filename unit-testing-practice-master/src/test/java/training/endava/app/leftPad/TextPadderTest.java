package training.endava.app.leftPad;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextPadderTest {

    private TextPadder padder = new TextPadder();

    @Test
    public void shouldNotPadTextWhenLenghtEqualsStringSize() {
        String result = padder.leftPad("abs", 3, '-');

        assertEquals("abs", result);
    }

    @Test
    public void shouldLeftPadTextWhenLengthExceedsStringSize() {
        String result = padder.leftPad("abs", 5, '-');

        assertEquals("--abs", result);
    }

    @Test
    public void shouldReturnFiveMinuses() {
        String result = padder.leftPad("", 5, '-');

        assertEquals("-----", result);
    }

    @Test
    public void shouldReturnFiveMinusesWhenPassingNull() {
        String result = padder.leftPad((String) null, 5, '-');

        assertEquals("-----", result);
    }

    @Test
    public void shouldReturnSameStringWhenLengthIsnegative() {
        String result = padder.leftPad("pisica", -10, '-');

        assertEquals("pisica", result);
    }

    @Test
    public void shouldPadNumber() {
        String result = padder.leftPad(42.12, 6, '-');

        assertEquals("-42.12", result);
    }

    @Test
    public void shouldPadNumberWithSpaceWhenNullCharIsPassed() {
        String result = padder.leftPad(42.12, 6, '\0');

        assertEquals(" 42.12", result);
    }
}
