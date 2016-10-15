package userInterface.customerUserInterface;

import businessLogic.CustomerBusinessLogic;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String customerId = (String) request.getParameter("customerId");

        System.out.println("****** " + customerId);
        List<Customer> customer = CustomerBusinessLogic.searchCustomerId(customerId);

        System.out.println("****** " + customerId + " " + customer.get(0).getFirstName() + " " + customer.get(0).getLastName());
        JSONObject jsonCustomer = new JSONObject();
        jsonCustomer.put("firstName", customer.get(0).getFirstName());
        jsonCustomer.put("lastName", customer.get(0).getLastName());

        response.setContentType("application/json");
        response.getWriter().print(jsonCustomer);

    }
}