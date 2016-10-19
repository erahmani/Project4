package businessLogic.loan;

import businessLogic.loan.exception.InValidGrantConditionFieldException;
import dataAccess.entity.GrantCondition;

public class GrantConditionBusinessLogic {
    public static void validateFields(GrantCondition grantCondition) {
        String errorMessage = "";
        boolean inValidField = false;

        if(grantCondition.getName().trim().isEmpty()){
            inValidField = true;
            errorMessage +="\nنام برای شرط اعطا مشخص نشده است.";
        }
        if(grantCondition.getMinDuration() == null){
            inValidField = true;
            errorMessage +="\nحداقل مدت قرار داد برای شرط اعطا مشخص نشده است.";
        }

        if(grantCondition.getMaxDuration() == null){
            inValidField = true;
            errorMessage +="\nحداکثر مدت قرار داد برای شرط اعطا مشخص نشده است.";
        }

        if(grantCondition.getMinCost() == null){
            inValidField = true;
            errorMessage +="\nحداقل مبلغ قرار داد برای شرط اعطا مشخص نشده است.";
        }

        if(grantCondition.getMaxCost() == null){
            inValidField = true;
            errorMessage +="\nحداکثر مبلغ قرار داد برای شرط اعطا مشخص نشده است.";
        }

        if(inValidField){
            throw new InValidGrantConditionFieldException(errorMessage);
        }
    }
}
