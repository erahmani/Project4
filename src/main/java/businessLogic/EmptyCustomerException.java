package businessLogic;

/**
 * Created by dotinschool1 on 10/15/2016.
 */
public class EmptyCustomerException extends RuntimeException {
    public EmptyCustomerException() {
    }

    public EmptyCustomerException(String message) {
        super(message);
    }
}
