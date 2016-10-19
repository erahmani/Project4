package businessLogic.loan.exception;

/**
 * Created by dotinschool1 on 10/17/2016.
 */
public class InValidLoanTypeFieldException extends RuntimeException {
    public InValidLoanTypeFieldException(String message) {
        super(message);
    }
}
