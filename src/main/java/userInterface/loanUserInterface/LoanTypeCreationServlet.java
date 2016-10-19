package userInterface.loanUserInterface;

import businessLogic.loan.LoanTypeBusinessLogic;
import businessLogic.loan.exception.EmptyGrantConditionException;
import businessLogic.loan.exception.InValidGrantConditionFieldException;
import businessLogic.loan.exception.InValidLoanTypeFieldException;
import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoanTypeCreationServlet", urlPatterns = {"/LoanTypeCreationServlet"})
public class LoanTypeCreationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            LoanType loanType = (LoanType) request.getSession().getAttribute("loanType");
            List<GrantCondition> grantConditionList = prepareGrantConditionsList(request);
            LoanTypeBusinessLogic.create(loanType, grantConditionList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("loanTypeJsp/successful_create_loan_type.jsp");
            dispatcher.forward(request, response);
        } catch (InValidLoanTypeFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("loanTypeJsp/create_loan_type.jsp");
            dispatcher.forward(request, response);
        } catch (EmptyGrantConditionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("loanTypeJsp/create_grant_condition.jsp");
            dispatcher.forward(request, response);
        } catch (InValidGrantConditionFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("loanTypeJsp/create_grant_condition.jsp");
            dispatcher.forward(request, response);
        }
    }

    private Short createShortNumber(String num) {
        try {
            return Short.parseShort(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private BigDecimal createBigDecimal(String num) {
        try {
            return new BigDecimal(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private List<GrantCondition> prepareGrantConditionsList(HttpServletRequest request) {
        String[] nameList = request.getParameterValues("name");
        String[] minDurationList = request.getParameterValues("minDuration");
        String[] maxDurationList = request.getParameterValues("maxDuration");
        String[] minCostList = request.getParameterValues("minCost");
        String[] maxCostList = request.getParameterValues("maxCost");

        List<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();
        if (nameList != null) {
            for (int i = 0; i < nameList.length; i++) {
                grantConditionList.add(new GrantCondition(nameList[i],
                        createShortNumber(minDurationList[i]),
                        createShortNumber(maxDurationList[i]),
                        createBigDecimal(minCostList[i]),
                        createBigDecimal(maxCostList[i])));
            }
        }
        return grantConditionList;
    }
}