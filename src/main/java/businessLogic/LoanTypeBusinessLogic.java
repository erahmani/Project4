package businessLogic;

import businessLogic.exception.EmptyFieldException;
import businessLogic.exception.EmptyGrantConditionException;
import dataAccess.LoanTypeCRUD;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;

import java.util.LinkedList;
import java.util.List;

public class LoanTypeBusinessLogic {
    public static void createCustomer(LoanType loanType, LinkedList<GrantCondition> grantConditionList) {
        if(grantConditionList.size() == 0){
            throw new EmptyGrantConditionException("حداقل یک شرط اعطا تعریف کنید!");
        }
        LoanTypeCRUD.create(loanType, grantConditionList);
    }

    public static void isValidLoanTypeFields(LoanType loanType) {
        if(loanType.getName().isEmpty()){
            throw new EmptyFieldException("Loan Type Empty Name Exception");
        }else if(loanType.getInterestRate().isEmpty()){
            throw new EmptyFieldException("Loan Type Empty Interest Rate Exception");
        }
    }

    public static List<LoanType> searchLoanType() {
        return LoanTypeCRUD.searchAll();
    }
}
