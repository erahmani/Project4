package userInterface.loanUserInterface;

import businessLogic.loan.LoanTypeBusinessLogic;
import dataAccess.entity.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoanFilePageCreationServlet", urlPatterns = {"/LoanFilePageCreationServlet"})
public class LoanFilePageCreationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<LoanType> loanTypeList = LoanTypeBusinessLogic.read();
        request.setAttribute("loanTypeList", loanTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("loanFileJsp/create_loan_file.jsp");
        requestDispatcher.forward(request, response);
    }
}