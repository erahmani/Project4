package businessLogic.loan;

import businessLogic.customer.CustomerBusinessLogic;
import businessLogic.loan.exception.InValidLoanFileFieldException;
import dataAccess.LoanFileCRUD;
import dataAccess.entity.Customer;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanFile;
import dataAccess.entity.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class LoanFileBusinessLogic {
    public static void create(Integer customerId, Integer loanTypeId, BigDecimal cost, Short duration) {
        List<Customer> customer = CustomerBusinessLogic.retrieveInfo(customerId);
        List<LoanType> loanType = LoanTypeBusinessLogic.retrieveInfo(loanTypeId);
        validateFields(loanType.get(0).getGrantConditionList(), duration, cost);
        LoanFileCRUD.create(new LoanFile(customer.get(0), loanType.get(0), cost, duration));
    }

    private static void validateFields(List<GrantCondition> grantConditionList, Short duration, BigDecimal cost) {
        String errorMessage = "";
        boolean inValidField = false;

        if (duration == null) {
            inValidField = true;
            errorMessage += "مدت قرار داد برای تسهیلات مورد نظر به درستی مشخص نشده است.";
        }
        if (cost == null) {
            inValidField = true;
            errorMessage += "مبلغ قرار داد برای تسهیلات مورد نظر به درستی مشخص نشده است.";
        }
        if (inValidField) {
            throw new InValidLoanFileFieldException(errorMessage);
        }
        for (GrantCondition grantCondition : grantConditionList) {
            if ((grantCondition.getMinCost().compareTo(cost) != 1 && grantCondition.getMaxCost().compareTo(cost) != -1) &&
                    (grantCondition.getMinDuration() <= duration && duration <= grantCondition.getMaxDuration())) {
                return;
            }
        }
        throw new InValidLoanFileFieldException("مبلغ یا مدت قرار داد در هیچ یک از شروط اعطای تسهیلات صدق نمیکند.");
    }

}
