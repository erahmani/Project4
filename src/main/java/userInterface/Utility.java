package userInterface;

import dataAccess.entity.Customer;

import javax.servlet.http.HttpServletRequest;

public class Utility {

    public static Customer initRealCustomer(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setCustomerId(request.getParameter("customerId"));
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setFatherName(request.getParameter("fatherName"));
        customer.setBirthDay(request.getParameter("birthDay"));
        customer.setNationalId(request.getParameter("nationalId"));
        return customer;
    }
}
