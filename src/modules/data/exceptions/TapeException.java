package modules.data.exceptions;

public class TapeException extends Exception{
    private String message;
    
    public TapeException(String message) {
        this.message = message;
    }
    
    @Override
    public void printStackTrace() {
        System.out.println("TapeException: " + message);
    }
}
