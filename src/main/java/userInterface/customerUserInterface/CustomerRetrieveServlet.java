package userInterface.customerUserInterface;

import businessLogic.CustomerBusinessLogic;
import dataAccess.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "CustomerRetrieveServlet", urlPatterns = {"/CustomerRetrieveServlet"})
public class CustomerRetrieveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  request.setCharacterEncoding("UTF-8");
       // response.setCharacterEncoding("UTF-8");
     //   String customerId = (String) request.getAttribute("customerId");
     //   System.out.println("fasdfasdf"+customerId);
        //System.out.println("fkajsdhfkjashdfkasdf");
        //request.setAttribute("firstName", "رحیمی");
        //request.setAttribute("lastName", "رحمانی");
        response.getWriter().println("fasldjkfsdflajsdlfkjalsdf");
       /* ArrayList<Customer> customer = CustomerBusinessLogic.searchCustomerId(customerId);
        if(!customer.isEmpty()){
            request.setAttribute("firstName", customer.get(0).getFirstName());
            request.setAttribute("lastName", customer.get(0).getLastName());
        }else{
            request.setAttribute("firstName", "");
            request.setAttribute("lastName", "");
        }*/
    }
}