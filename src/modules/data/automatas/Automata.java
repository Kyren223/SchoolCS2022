package modules.data.automatas;

import modules.data.connections.Connection;
import modules.data.exceptions.AutomataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Automata {
    public static final String STARTER_STATE = "s";
    public static final String STARTER_STATE_ACCEPTANCE = "S";

    protected HashMap<String, List<Connection>> statesConnections;
    private final boolean isFull;

    public Automata(boolean isFull) {
        statesConnections = new HashMap<>();
        this.isFull = isFull; // Requires all input to all connections
    }

    public void addLine(String line) throws AutomataException {
        // "q0->Q1/a,b" capitalized means acceptance state
        String[] conditionSep = line.split("/");
        String statesString = conditionSep[0];
        String[] states = statesString.split("->");
        String[] conditions = conditionSep[1].split(",");

        addState(states[0]);
        addState(states[1]);
    
        for (String condition : conditions) {
            addConnection(states[0], new Connection(condition.toCharArray()[0], states[1]));
        }
    }
    
    protected void addState(String state) {
        if (statesConnections.containsKey(state)) return;
        statesConnections.put(state, new ArrayList<>());
    }
    
    protected void addConnection(String state, Connection connection) {
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
        for (char c : in) {
            List<Connection> connections = statesConnections.getOrDefault(state, null);
            if (connections == null) throw new AutomataException("State has no connections");
        
            Connection passedConnection = null;
            for (Connection connection : connections) {
                boolean passed = connection.pass(c);
                if (passedConnection != null && passed) {
                    throw new AutomataException("Cannot determine path, non-deterministic automata");
                }
                if (passed) passedConnection = connection;
            }
        
            if (passedConnection == null) {
                if (isFull) throw new AutomataException("Full automata requires all paths for a given input");
                else return false; // input doesn't get accepted, no path
            }
        
            state = passedConnection.getState();
            if (!statesConnections.containsKey(state)) throw new AutomataException("State doesn't exist");
        }
        return isAcceptanceState(state);
    }
    
    protected String getStarterState() throws AutomataException {
        boolean starter = statesConnections.containsKey(STARTER_STATE);
        boolean starterAcceptance = statesConnections.containsKey(STARTER_STATE_ACCEPTANCE);
        if (starter && starterAcceptance) throw new AutomataException("More than 1 starter state is not allowed");
        else if (!starter && !starterAcceptance) throw new AutomataException("No starter state found");
        return starter ? STARTER_STATE : STARTER_STATE_ACCEPTANCE;
    }

    protected boolean isAcceptanceState(String state) {
        return state.equals(state.toUpperCase());
    }
}
