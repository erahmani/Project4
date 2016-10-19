package userInterface.customerUserInterface;

import businessLogic.customer.CustomerBusinessLogic;
import businessLogic.customer.exception.InValidCustomerIdException;
import dataAccess.entity.Customer;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerRetrieveServlet", urlPatterns = {"/CustomerRetrieveServlet"})
public class CustomerRetrieveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonCustomer = new JSONObject();
        try {
            String customerId = request.getParameter("customerId");
            List<Customer> customer = CustomerBusinessLogic.retrieveInfo(Integer.parseInt(customerId));
            jsonCustomer.put("firstName", customer.get(0).getFirstName());
            jsonCustomer.put("lastName", customer.get(0).getLastName());
            response.setContentType("application/json");
            response.getWriter().print(jsonCustomer);
        } catch (InValidCustomerIdException e) {
            jsonCustomer.put("address", "/LoanFilePageCreationServlet?errorMessage=" + e.getMessage());
            response.setContentType("application/json");
            response.getWriter().print(jsonCustomer);
        }
    }
}