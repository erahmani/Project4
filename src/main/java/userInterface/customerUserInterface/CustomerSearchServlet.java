package userInterface.customerUserInterface;

import businessLogic.customer.CustomerBusinessLogic;
import dataAccess.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerSearchServlet", urlPatterns = {"/CustomerSearchServlet"})
public class CustomerSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String searchOption = ("searchOption");
        String searchValue = req.getParameter("searchValue");

        List<Customer> customerList = CustomerBusinessLogic.read(req.getParameter("firstName"), req.getParameter("lastName"),
             req.getParameter("customerId"), req.getParameter("nationalId"));

        req.setAttribute("searchOption", searchOption);
        req.setAttribute("searchValue", searchValue);
        req.setAttribute("customerList", customerList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerJsp/search_customer_result.jsp");
        requestDispatcher.forward(req, resp);
    }
}