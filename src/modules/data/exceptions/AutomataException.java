package modules.data.exceptions;

import java.util.logging.Logger;

public class AutomataException extends Exception {
    private final String message;

    public AutomataException(String message) {
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        System.out.println("InvalidAutomataException: " + message);
    }
}
