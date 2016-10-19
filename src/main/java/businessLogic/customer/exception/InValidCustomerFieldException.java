package businessLogic.customer.exception;

/**
 * Created by dotinschool1 on 10/17/2016.
 */
public class InValidCustomerFieldException extends  RuntimeException {
    public InValidCustomerFieldException(String message) {
        super(message);
    }
}
