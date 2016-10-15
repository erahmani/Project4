package businessLogic;

import dataAccess.LoanFileCRUD;
import dataAccess.entity.LoanFile;

public class LoanFileBusinessLogic {
    public static void create(LoanFile loanFile) {
        if(isValidLoanFileFields(loanFile)){
            LoanFileCRUD.create(loanFile);
        }
    }

    private static boolean isValidLoanFileFields(LoanFile loanFile) {
        if(loanFile.getCustomer() == null){
            throw new EmptyCustomerException("No Customer Selected!");
        }

        CustomerBusinessLogic.isValidCustomerFields(loanFile.getCustomer());
        LoanTypeBusinessLogic.isValidLoanTypeFields(loanFile.getLoanType());

        return true;
    }
}
