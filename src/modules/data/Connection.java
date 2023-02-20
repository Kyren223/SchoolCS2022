package modules.data;

public class Connection {
    private char condition;
    private String toState;

    public Connection(char condition, String toState) {
        this.condition = condition;
        this.toState = toState;
    }

    public boolean pass(char input) {
        return condition == input;
    }

    public String getState() {
        return toState;
    }
}
