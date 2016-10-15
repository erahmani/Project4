package userInterface.loanUserInterface;

import businessLogic.LoanTypeBusinessLogic;
import dataAccess.entity.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoanFileCreationServlet", urlPatterns = {"/LoanFileCreationServlet"})
public class LoanFileCreationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<LoanType> loanTypeList = LoanTypeBusinessLogic.searchLoanType();
        request.setAttribute("loanTypeList", loanTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create_loan_file.jsp");
        requestDispatcher.forward(request, response);
    }

}