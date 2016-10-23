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
            System.out.println("customerId:" + createIntegerNumber(customerId));
            List<Customer> customer = CustomerBusinessLogic.retrieveInfo(createIntegerNumber(customerId));
            jsonCustomer.put("firstName", customer.get(0).getFirstName());
            jsonCustomer.put("lastName", customer.get(0).getLastName());
            response.setContentType("application/json");
            response.getWriter().print(jsonCustomer);
        } catch (InValidCustomerIdException e) {
            System.out.println(e.getMessage());
            jsonCustomer.put("errorMessage", e.getMessage());
            response.setContentType("application/json");
            response.getWriter().print(jsonCustomer);
        }
    }

    private Integer createIntegerNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}