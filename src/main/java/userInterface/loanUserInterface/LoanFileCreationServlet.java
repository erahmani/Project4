package userInterface.loanUserInterface;


import businessLogic.customer.exception.InValidCustomerIdException;
import businessLogic.loan.LoanFileBusinessLogic;
import businessLogic.loan.exception.InValidLoanFileFieldException;
import businessLogic.loan.exception.InValidLoanTypeIdException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "LoanFileCreationServlet", urlPatterns = {"/LoanFileCreationServlet"})
public class LoanFileCreationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        Integer customerId = createIntegerNumber(request.getParameter("customerId"));
        Integer loanTypeId = createIntegerNumber(request.getParameter("loanTypeList"));
        Short duration = createShortNumber(request.getParameter("duration"));
        BigDecimal cost = createBigDecimal(request.getParameter("cost"));

        try {
            LoanFileBusinessLogic.create(customerId, loanTypeId, cost, duration);
            RequestDispatcher dispatcher = request.getRequestDispatcher("loanFileJsp/successful_create_loan_file.jsp");
            dispatcher.forward(request, response);
        } catch (InValidCustomerIdException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LoanFilePageCreationServlet");
            dispatcher.forward(request, response);
        } catch (InValidLoanTypeIdException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LoanFilePageCreationServlet");
            dispatcher.forward(request, response);
        } catch (InValidLoanFileFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LoanFilePageCreationServlet");
            dispatcher.forward(request, response);
        }
    }

    private Integer createIntegerNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return null;
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
}