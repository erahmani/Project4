package businessLogic.loan;

import businessLogic.loan.exception.EmptyGrantConditionException;
import businessLogic.loan.exception.InValidLoanTypeFieldException;
import businessLogic.loan.exception.InValidLoanTypeIdException;
import dataAccess.LoanTypeCRUD;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import log4j.Log;

import java.util.List;

public class LoanTypeBusinessLogic {
    public static void create(LoanType loanType, List<GrantCondition> grantConditionList) {
        validateFields(loanType, grantConditionList);
        Log.log.info("ایجاد نوع تسهیلات جدید به نام "+ loanType.getName());
        LoanTypeCRUD.create(loanType, grantConditionList);
    }

    private static void validateFields(LoanType loanType, List<GrantCondition> grantConditionList) {
        String errorMessage = "";
        boolean inValidField = false;

        if (loanType.getName() == null || loanType.getName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "نامی برای تسهیلات مورد نظر مشخص نشده است.\n";
        }
        if (loanType.getInterestRate() == null) {
            inValidField = true;
            errorMessage += "میزان نرخ سود برای تسهیلات مورد نظر مشخص نشده است.\n";
        }
        if (inValidField) {
            Log.log.error("مشکل در ایجاد نوع تسهیلات:" + errorMessage);
            throw new InValidLoanTypeFieldException(errorMessage);
        }
        if (grantConditionList.size() == 0) {
            Log.log.error("مشکل در ایجاد نوع تسهیلات: حداقل باید یک شرط اعطا برای تسهیلات مورد نظر تعریف شود.");
            throw new EmptyGrantConditionException("حداقل باید یک شرط اعطا برای تسهیلات مورد نظر تعریف شود.");
        }

        for (GrantCondition grantCondition : grantConditionList) {
            GrantConditionBusinessLogic.validateFields(grantCondition);
        }
    }

    public static List<LoanType> read() {
        return LoanTypeCRUD.read(null);//?????
    }

    static List<LoanType> retrieveInfo(Integer id) {
        List<LoanType> loanTypeList = LoanTypeCRUD.read(id);
        if (loanTypeList.size() == 0) {
            Log.log.error("بازیابی اطلاعات نوع تسهیلات: نوع تسهیلات انتخاب شده صحیح نمی باشد.");
            throw new InValidLoanTypeIdException("نوع تسهیلات انتخاب شده صحیح نمی باشد.");
        }
        Log.log.info(loanTypeList.get(0).getName() + "بازیابی اطلاعات نوع تسهیلات: به نام ");
        return loanTypeList;
    }
}
