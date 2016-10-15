package userInterface.customerUserInterface;

import businessLogic.CustomerBusinessLogic;
import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import businessLogic.exception.InValidNationalIdException;
import dataAccess.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerRegistrationServlet", urlPatterns = {"/CustomerRegistrationServlet"})
public class CustomerRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            Customer customer = new Customer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("fatherName"),
                    request.getParameter("birthDay"), request.getParameter("nationalId"));
            int customerId = CustomerBusinessLogic.createCustomer(customer);
            request.setAttribute("customerId", customerId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("successful_register.jsp");
            requestDispatcher.forward(request, response);
        } catch (DuplicateUniqueCodeException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register_customer.jsp");
            requestDispatcher.forward(request, response);
        } catch (EmptyFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register_customer.jsp");
            requestDispatcher.forward(request, response);
        } catch (InValidNationalIdException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register_customer.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
