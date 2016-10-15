package businessLogic;

/**
 * Created by dotinschool1 on 10/15/2016.
 */
public class EmptyGrantConditionException extends RuntimeException {
    public EmptyGrantConditionException() {
    }

    public EmptyGrantConditionException(String message) {
        super(message);
    }
}
