package modules.data.automatas;

import modules.data.Direction;
import modules.data.Tape;
import modules.data.TapeValue;
import modules.data.automatas.Automata;
import modules.data.connections.Connection;
import modules.data.connections.TConnection;
import modules.data.exceptions.AutomataException;
import modules.data.exceptions.TapeException;
import modules.data.exceptions.TuringAutomataException;

import java.util.List;

public class TuringAutomata extends Automata {
    
    public TuringAutomata() {
        super(false);
    }
    
    @Override
    public void addLine(String line) throws TuringAutomataException, TapeException {
        // "q0->Q1/a,b/A,B/L"
        String[] subArgs = line.split("/");

        String[] states = subArgs[0].split("->");
        String[] conditions = subArgs[1].split(",");
        String[] newValues = subArgs[2].split(",");
        Direction direction = Direction.getDirection(subArgs[3].toCharArray()[0]);
        
        if (direction == Direction.INVALID) throw new TuringAutomataException("Invalid Direction");
        if (conditions.length != newValues.length)
            throw new TuringAutomataException("Conditions and new values length's are not matching");
    
        addState(states[0]);
        addState(states[1]);
    
        for (int i = 0; i < conditions.length; i++) {
            TapeValue read = new TapeValue(conditions[i]);
            TapeValue write = new TapeValue(newValues[i]);
            addConnection(states[0],
                    new TConnection(read, states[1], write, direction));
        }
    }

    public boolean run(String input) throws AutomataException, TapeException {
        return run(new Tape(input));
    }

    /**
     *
     * @param tape The input tape to use, this tape will get modified
     * @return True if the input (initial state of the tape) is accepted, false otherwise
     * @throws AutomataException If the automata is invalid
     * @throws TapeException If the tape is invalid/becomes invalid
     */
    public boolean run(Tape tape) throws AutomataException, TapeException {
        String state = getStarterState();

        while (!isAcceptanceState(state)) {
            if (!statesConnections.containsKey(state))
                throw new TuringAutomataException("Non existent state - " + state);

            TConnection passer = null;
            List<Connection> connections = statesConnections.get(state);
            for (Connection con : connections) {
                TConnection connection = (TConnection) con;
                if (connection.pass(tape.read())) passer = connection;
            }

            // No paths can pass, stuck in this state, input wasn't accepted
            if (passer == null) return false;

            tape.write(passer.getWriteValue());
            tape.move(passer.getDir());

            if (isAcceptanceState(state)) return true;
            state = passer.getState();
        }
        
        return true;
    }
    
    
}
