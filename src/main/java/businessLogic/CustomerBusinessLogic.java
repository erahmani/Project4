package businessLogic;

import businessLogic.exception.DuplicateUniqueCodeException;
import businessLogic.exception.EmptyFieldException;
import businessLogic.exception.InValidNationalId;
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

    private static void realCustomerFieldValidation(String firstName, String lastName, String fatherName, String birthDay, String nationalId) {
        if (firstName.isEmpty()) {
            throw new EmptyFieldException("First Name Is Empty!");
        }
        if (lastName.isEmpty()) {
            throw new EmptyFieldException("Last Name Is Empty!");
        }
        if (fatherName.isEmpty()) {
            throw new EmptyFieldException("Father Name Is Empty!");
        }
        if (birthDay.isEmpty()) {
            throw new EmptyFieldException("Birth Day Is Empty!");
        }
        if (nationalId.isEmpty()) {
            throw new EmptyFieldException("National ID Is Empty!");
        } else if (!isValidNationalId(nationalId)) {
            throw new InValidNationalId("National ID Is not Valid");
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

    public static int createCustomer(String firstName, String lastName, String fatherName, String birthDay, String nationalId) {
        realCustomerFieldValidation(firstName, lastName, fatherName, birthDay, nationalId);

        ArrayList<dataAccess.entity.Customer> customerList = searchNationalId(nationalId);
        if (customerList.size() == 0) {
            return CustomerCRUD.create(firstName, lastName, fatherName, birthDay, nationalId);
        } else {
            throw new DuplicateUniqueCodeException("This National Is Inserted !!!");
        }
    }

    public static ArrayList<Customer> selectFirstName(String firstName) {
        return CustomerCRUD.selectFirstName(firstName);
    }

    public static ArrayList<Customer> searchLastName(String lastName) {
        return CustomerCRUD.searchLastName(lastName);
    }

    public static ArrayList<Customer> searchNationalId(String nationalId) {
        return CustomerCRUD.selectNationalId(nationalId);
    }

    public static ArrayList<Customer> searchCustomerId(String customerId) {
        return CustomerCRUD.searchCustomerId(customerId);
    }

    public static void editCustomer(Integer customerId, String firstName, String lastName, String fatherName, String birthDay, String nationalId) {
        realCustomerFieldValidation(firstName, lastName, fatherName, birthDay, nationalId);
        ArrayList<dataAccess.entity.Customer> customerList = searchNationalId(nationalId);
        if (customerList.size() == 0 || (customerList.size() == 1 && customerList.get(0).getCustomerId().equals(customerId))) {
            CustomerCRUD.update(customerId, firstName, lastName, fatherName, birthDay, nationalId);
        } else {
            throw new DuplicateUniqueCodeException("National Id Is Inserted !!!");
        }
    }

    public static void deleteCustomer(Integer customerId) {
        CustomerCRUD.delete(customerId);
    }


}
