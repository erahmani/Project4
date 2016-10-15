package businessLogic;

import businessLogic.exception.EmptyGrantConditionException;
import dataAccess.LoanTypeCRUD;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;

import java.util.LinkedList;

/**
 * Created by dotinschool1 on 10/15/2016.
 */
public class LoanTypeBusinessLogic {
    public static void createCustomer(LoanType loanType, LinkedList<GrantCondition> grantConditionList) {
        if(grantConditionList.size() == 0){
            throw new EmptyGrantConditionException("حداقل یک شرط اعطا تعریف کنید!");
        }
        LoanTypeCRUD.create(loanType, grantConditionList);
    }
}
