package training.endava.app.leftPad;

public class TextPadder {

    public String leftPad(Number number, int length, char chr) {
        return leftPad(String.valueOf(number), length, chr);
    }

    public String leftPad(String s, int length, char paddingCharacter) {
        int i = 0;
        paddingCharacter = paddingCharacter == '\0' ? ' ' : paddingCharacter;
        s = s == null ? "" : s;
        length = length - s.length();
        while (i++ < length)
            s = paddingCharacter + s;
        return s;
    }

}
