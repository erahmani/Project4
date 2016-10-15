package userInterface.loanUserInterface;

import businessLogic.LoanTypeBusinessLogic;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "GrantConditionCreationServlet", urlPatterns = {"/GrantConditionCreationServlet"})
public class GrantConditionCreationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        LoanType loanType = (LoanType) request.getSession().getAttribute("loanType");
        LinkedList<GrantCondition> grantConditionList = prepareGrantConditionsList(request);
        LoanTypeBusinessLogic.createCustomer(loanType, grantConditionList);
    }

    private LinkedList<GrantCondition> prepareGrantConditionsList(HttpServletRequest request) {
        String[] nameList = request.getParameterValues("name");
        String[] minDurationList = request.getParameterValues("minDuration");
        String[] maxDurationList = request.getParameterValues("maxDuration");
        String[] minCostList = request.getParameterValues("minCost");
        String[] maxCostList = request.getParameterValues("maxCost");

        LinkedList<GrantCondition> grantConditionList = new LinkedList<GrantCondition>();
        for (int i = 0; i < nameList.length; i++) {
            GrantCondition grantCondition = new GrantCondition(nameList[i], minDurationList[i],
                    maxDurationList[i], minCostList[i], maxCostList[i]);
            grantConditionList.add(grantCondition);
        }
        return grantConditionList;
    }
}