package Exceptions;

public class doubleKeyException extends Exception {

    // Is thrown when a key which already exists is tried to added again. Keys are unique.

    public doubleKeyException(String errorMessage){
        super(errorMessage);
    }
    
}
