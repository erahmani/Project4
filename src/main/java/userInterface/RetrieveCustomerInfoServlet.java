package userInterface;

import businessLogic.CustomerBusinessLogic;
import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import dataAccess.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RetrieveCustomerInfoServlet", urlPatterns = {"/RetrieveCustomerInfoServlet"})
public class RetrieveCustomerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
