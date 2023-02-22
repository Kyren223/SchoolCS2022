package modules.data.connections;

public class Connection {
    protected char condition;
    protected String toState;

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
