package modules.data;

public enum Direction {
    LEFT,
    RIGHT,
    INVALID;
    public static Direction getDirection(char c) {
        if (c == 'L' || c == 'l') return LEFT;
        if (c == 'R' || c == 'r') return RIGHT;
        return INVALID;
    }
}
