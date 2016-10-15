package businessLogic;

import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import businessLogic.exception.InValidCustomerIdException;
import businessLogic.exception.InValidNationalIdException;
import dataAccess.CustomerCRUD;
import dataAccess.entity.Customer;

import javax.persistence.Column;
import java.util.ArrayList;

public class CustomerBusinessLogic {

    private String customerId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String fatherName;
    @Column(nullable = false)
    private String birthDay;

    public static void isValidCustomerFields(Customer customer) {
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
        } else if (!isValidNationalId(customer.getNationalId())) {
            throw new InValidNationalIdException("National ID Is not Valid");
        }
    }

    private static boolean isValidNationalId(String nationalId) {
        if (nationalId.length() != 10) {
            return false;
        } else {
            int check = 0;
            for (int i = 0; i < nationalId.length() - 1; i++) {
                int num = Integer.parseInt(nationalId.substring(i, i + 1));
                check += num * (10 - i);
            }
            if (check % 11 == Integer.parseInt(nationalId.substring(nationalId.length() - 1, nationalId.length()))
                    || check % 11 == 11 - Integer.parseInt(nationalId.substring(nationalId.length() - 1, nationalId.length()))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int createCustomer(Customer customer) {
        isValidCustomerFields(customer);

        ArrayList<dataAccess.entity.Customer> customerList = searchNationalId(customer.getNationalId());
        if (customerList.size() == 0) {
            return CustomerCRUD.create(customer);
        } else {
            throw new DuplicateUniqueCodeException("This National Is Inserted !!!");
        }
    }

    public static ArrayList<Customer> searchFirstName(String firstName) {
        return CustomerCRUD.selectFirstName(firstName);
    }

    public static ArrayList<Customer> searchLastName(String lastName) {
        return CustomerCRUD.selectLastName(lastName);
    }

    public static ArrayList<Customer> searchNationalId(String nationalId) {
        return CustomerCRUD.selectNationalId(nationalId);
    }

    public static ArrayList<Customer> searchCustomerId(String customerId) {
        ArrayList<Customer> customerList = CustomerCRUD.searchCustomerId(customerId);
        if (customerList.size() == 0) {
            throw new InValidCustomerIdException("Customer Id Is Invalid");
        }
        return customerList;
    }

    public static void editCustomer(Customer customer) {
        isValidCustomerFields(customer);
        ArrayList<dataAccess.entity.Customer> customerList = searchNationalId(customer.getNationalId());
        if (customerList.size() == 0 || (customerList.size() == 1 && customerList.get(0).getCustomerId().equals(customer.getCustomerId()))) {
            CustomerCRUD.update(customer);
        } else {
            throw new DuplicateUniqueCodeException("National Id Is Inserted !!!");
        }
    }

    public static void deleteCustomer(Integer customerId) {
        CustomerCRUD.delete(customerId);
    }

}
