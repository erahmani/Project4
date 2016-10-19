package userInterface.customerUserInterface;

import businessLogic.customer.CustomerBusinessLogic;
import businessLogic.customer.exception.InValidCustomerFieldException;
import dataAccess.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerEditionServlet", urlPatterns = {"/CustomerEditionServlet"})
public class CustomerEditionServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            Customer customer = new Customer(Integer.parseInt(request.getParameter("customerId")), request.getParameter("firstName"), request.getParameter("lastName"),
                    request.getParameter("fatherName"), request.getParameter("birthDay"), request.getParameter("nationalId"));
            CustomerBusinessLogic.update(customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerJsp/successful_edit_customer.jsp");
            requestDispatcher.forward(request, response);
        } catch (InValidCustomerFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerJsp/edit_customer.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
