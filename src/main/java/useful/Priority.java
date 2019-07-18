package useful;

public  enum Priority {
    VERY_IMPORTANT(6),
    IMPORTANT(5),
    MID_IMPORTANT(4),
    NOT_IMPORTANT(3),
    UNKONWN(2),
    UNMENTIONED(1);

    private final int value;

    Priority(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
