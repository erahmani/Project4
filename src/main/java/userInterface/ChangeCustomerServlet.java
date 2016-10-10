package userInterface;

import businessLogic.CustomerBusinessLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ChangeCustomerServlet", urlPatterns = {"/ChangeCustomerServlet"})
public class ChangeCustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("Delete") != null) {
            String customerId = request.getParameter("customerId");
            CustomerBusinessLogic.deleteCustomer(Integer.parseInt(customerId));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SuccessfulDeletion.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("Edit") != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerEdition.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}