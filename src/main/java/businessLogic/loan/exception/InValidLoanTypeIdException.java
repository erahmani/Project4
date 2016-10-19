package businessLogic.loan.exception;

/**
 * Created by dotinschool1 on 10/17/2016.
 */
public class InValidLoanTypeIdException extends RuntimeException{
    public InValidLoanTypeIdException(String message) {
        super(message);
    }
}
