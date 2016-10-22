package businessLogic.loan;

import businessLogic.loan.exception.InValidGrantConditionFieldException;
import dataAccess.entity.GrantCondition;
import log4j.Log;

class GrantConditionBusinessLogic {
    static void validateFields(GrantCondition grantCondition) {
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
            Log.log.error(errorMessage + "مشکل در ایجاد شرط اعطا:");
            throw new InValidGrantConditionFieldException(errorMessage);
        }
    }
}
