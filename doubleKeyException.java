package Dict;

public class doubleKeyException extends Exception {

    // Is thrown when a key which already exists is tried to added again. Keys are unique.

    doubleKeyException(String errorMessage){
        super(errorMessage);
    }
    
}
