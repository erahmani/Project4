package userInterface.customerUserInterface;

import businessLogic.CustomerBusinessLogic;
import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import businessLogic.exception.InValidNationalId;

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
            CustomerBusinessLogic.editCustomer(Integer.parseInt(request.getParameter("customerId")), request.getParameter("firstName"), request.getParameter("lastName"),
                    request.getParameter("fatherName"), request.getParameter("birthDay"), request.getParameter("nationalId"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SuccessfulEdition.jsp");
            requestDispatcher.forward(request, response);
        } catch (DuplicateUniqueCodeException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerEdition.jsp");
            requestDispatcher.forward(request, response);
        }catch (EmptyFieldException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerEdition.jsp");
            requestDispatcher.forward(request, response);
        } catch (InValidNationalId e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerEdition.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
