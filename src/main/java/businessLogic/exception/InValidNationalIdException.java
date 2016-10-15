package businessLogic.exception;

/**
 * Created by dotinschool1 on 10/9/2016.
 */
public class InValidNationalIdException extends RuntimeException {
    public InValidNationalIdException() {
    }

    public InValidNationalIdException(String message) {
        super(message);
    }
}

