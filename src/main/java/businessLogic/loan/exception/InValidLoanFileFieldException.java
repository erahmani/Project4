package businessLogic.loan.exception;

/**
 * Created by dotinschool1 on 10/17/2016.
 */
public class InValidLoanFileFieldException extends RuntimeException{
    public InValidLoanFileFieldException(String message) {
        super(message);
    }
}
