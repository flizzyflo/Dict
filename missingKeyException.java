package Dict;

public class missingKeyException extends Exception{

    // Exception is thrown when a specific key is looked up, but does not exist within the dictionary.
    
    missingKeyException(String errorMessage){
        super(errorMessage)
    }
}
