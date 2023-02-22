package modules.data.exceptions;

import java.util.logging.Logger;

public class AutomataException extends Exception {
    protected final String message;

    public AutomataException(String message) {
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        System.out.println("InvalidAutomataException: " + message);
    }
}
