package modules.data.automatas;

import modules.data.Direction;
import modules.data.Tape;
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
    public void addLine(String line) throws TuringAutomataException {
        // "q0->Q1/a,b|A,B/L"
        String[] turingSep = line.split("//|");
        
        String[] conditionSep = turingSep[0].split("/");
        String[] turingArgs = turingSep[1].split("/");
        
        String[] states = conditionSep[0].split("->");
        String[] conditions = conditionSep[1].split(",");
        String[] newValues = turingArgs[0].split(",");
        Direction direction = Direction.getDirection(turingArgs[1].toCharArray()[0]);
        
        if (direction == Direction.INVALID) throw new TuringAutomataException("Invalid Direction");
        if (conditions.length != newValues.length)
            throw new TuringAutomataException("Conditions and new values length's are not matching");
    
        addState(states[0]);
        addState(states[1]);
    
        for (int i = 0; i < conditions.length; i++) {
            addConnection(states[0],
                    new TConnection(conditions[i].toCharArray()[0], states[1],
                            newValues[i].toCharArray()[0], direction));
        }
    }
    
    @Override
    public boolean run(String input) throws AutomataException, TapeException {
        return run(input, null);
    }
    
    public boolean run(String input, Tape wantedEndResult) throws AutomataException, TapeException {
        Tape tape = new Tape(input);
        String state = getStarterState();
        
        TConnection connection = (TConnection) statesConnections.get(state).get(0);
        if (connection.pass(tape.read())) {
        
        }
        
        return false;
    }
    
    
}
