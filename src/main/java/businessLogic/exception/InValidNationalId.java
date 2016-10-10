package businessLogic.exception;

/**
 * Created by dotinschool1 on 10/9/2016.
 */
public class InValidNationalId extends RuntimeException {
    public InValidNationalId() {
    }

    public InValidNationalId(String message) {
        super(message);
    }
}

