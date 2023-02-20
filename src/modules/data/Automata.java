package modules.data;

import modules.data.exceptions.AutomataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Automata {
    public static final String STARTER_STATE = "s";
    public static final String STARTER_STATE_ACCEPTANCE = "S";

    private HashMap<String, List<Connection>> statesConnections;
    private boolean isFull;

    public Automata(boolean isFull) {
        statesConnections = new HashMap<>();
        this.isFull = isFull; // Requires all input to all connections
    }

    public void addLine(String line) {
        // "q0->Q1/a" capitalized means acceptance state
        String[] conditionSep = line.split("/");
        String statesString = conditionSep[0];
        String[] states = statesString.split("->");

        Connection connection = new Connection(conditionSep[1].toCharArray()[0], states[1]);
        addState(states[0]);
        addConnection(states[0], connection);
    }

    private void addState(String state) {
        statesConnections.put(state, new ArrayList<>());
    }

    private void addConnection(String state, Connection connection) {
        if (!statesConnections.containsKey(state)) return;
        statesConnections.get(state).add(connection);
    }

    /***
     * Runs the automata with the given input
     * There must be ONLY one state named "s" OR "S" to indicate for starter state
     * @param input The string of characters that the automata gets as an input
     * @return true if the final input ended in an acceptance state, false otherwise
     * @throws modules.data.exceptions.AutomataException if there are no, or multiple starter states
     */
    public boolean run(String input) throws AutomataException {
        char[] in = input.toCharArray();
        String state = getStarterState();

        // For each input
        for (int i = 0; i < in.length; i++) {
            List<Connection> connections = statesConnections.getOrDefault(state, null);
            if (connections == null) throw new AutomataException("State has no connections");

            Connection passed = null;
            for (Connection connection : connections) {
                if (passed != null) throw new AutomataException("Cannot determine path, non-deterministic automata");
                if (connection.pass(in[i])) passed = connection;
            }

            if (passed == null) {
                if (isFull) throw new AutomataException("Full automata requires all paths for a given input");
                else return false; // input doesn't get accepted, no path
            }

            state = passed.getState();
            if (!statesConnections.containsKey(state)) throw new AutomataException("State doesn't exist");
        }
        return isAcceptanceState(state);
    }

    private String getStarterState() throws AutomataException {
        boolean starter = statesConnections.containsKey(STARTER_STATE);
        boolean starterAcceptance = statesConnections.containsKey(STARTER_STATE_ACCEPTANCE);
        if (starter && starterAcceptance) throw new AutomataException("More than 1 starter state is not allowed");
        else if (!starter && !starterAcceptance) throw new AutomataException("No starter state found");
        return starter ? STARTER_STATE : STARTER_STATE_ACCEPTANCE;
    }

    private boolean isAcceptanceState(String state) {
        return state.equals(state.toUpperCase());
    }
}
