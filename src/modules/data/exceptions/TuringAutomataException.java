package modules.data.exceptions;

public class TuringAutomataException extends AutomataException{
    public TuringAutomataException(String message) {
        super(message);
    }
    
    @Override
    public void printStackTrace() {
        System.out.println("InvalidTuringAutomataException: " + message);
    }
}
