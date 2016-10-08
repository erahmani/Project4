package businessLogic;

import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import dataAccess.CustomerCRUD;
import dataAccess.entity.Customer;

import java.util.LinkedList;

public class CustomerBusinessLogic  {

    private static void realCustomerFieldValidation(Customer customer) {
        if (customer.getFirstName().isEmpty()) {
            throw new EmptyFieldException("First Name Is Empty!");
        }
        if (customer.getLastName().isEmpty()) {
            throw new EmptyFieldException("Last Name Is Empty!");
        }
        if (customer.getFatherName().isEmpty()) {
            throw new EmptyFieldException("Father Name Is Empty!");
        }
        if (customer.getBirthDay().isEmpty()) {
            throw new EmptyFieldException("Birth Day Is Empty!");
        }
        if (customer.getNationalId().isEmpty()) {
            throw new EmptyFieldException("National ID Is Empty!");
        }
    }

    public static void createNewCustomer(Customer customer) {
        realCustomerFieldValidation(customer);
        LinkedList<Customer> customerList = CustomerCRUD.selectRealCustomer("nationalId", customer.getNationalId());
        if (customerList.size() == 0) {
            CustomerCRUD.insertRealCustomer(customer);
        } else {
            throw new DuplicateUniqueCodeException("This National Is Inserted !!!");
        }
    }

    public static LinkedList<Customer> searchRealCustomer(String searchOption, String searchValue) {
        return CustomerCRUD.selectRealCustomer(searchOption, searchValue);
    }

    public static void editCustomer(Customer customer) {
        realCustomerFieldValidation(customer);
        LinkedList<Customer> customerList = CustomerCRUD.selectRealCustomer("nationalId", customer.getNationalId());
        System.out.println();
        if (customerList.size() == 0 || (customerList.size() == 1 && customerList.get(0).getCustomerId().equals(customer.getCustomerId()))) {
            CustomerCRUD.updateRealCustomer(customer);
        } else {
            throw new DuplicateUniqueCodeException("This Economic Code Is Inserted !!!");
        }
    }

    public static void deleteCustomer(String customerId) {
        CustomerCRUD.deleteCustomer(customerId);
    }
}
