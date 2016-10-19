package businessLogic.customer;

import businessLogic.customer.exception.InValidCustomerFieldException;
import businessLogic.customer.exception.InValidCustomerIdException;
import dataAccess.CustomerCRUD;
import dataAccess.entity.Customer;

import java.util.List;

public class CustomerBusinessLogic {
    public static void validateFields(Customer customer) {
        String errorMessage = "";
        boolean inValidField = false;
        if (customer.getFirstName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "First Name Is Empty!\n";
        }
        if (customer.getLastName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "Last Name Is Empty!\n";
        }
        if (customer.getFatherName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "Father Name Is Empty!\n";
        }
        if (customer.getBirthDay().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "Birth Day Is Empty!\n";
        }
        if (customer.getNationalId().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "National ID Is Empty!\n";
        }
        if (inValidField) {
            throw new InValidCustomerFieldException(errorMessage);
        }
        validateNationalId(customer);
    }

    private static void validateNationalId(Customer customer) {
        if (!isNationalIdValid(customer.getNationalId())) {
            throw new InValidCustomerFieldException("کد ملی وارد شده صحیح نمیباشد.");
        }
        if (!isNationalIdUnique(customer)) {
            throw new InValidCustomerFieldException("کد ملی وارد شده تکراری است.");
        }
    }

    private static boolean isNationalIdValid(String nationalId) {
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

    private static boolean isNationalIdUnique(Customer customer) {
        List<Customer> customerList = read(null, null, null, customer.getNationalId());
        if ((customerList.size() == 0) || (customerList.size() == 1 && customerList.get(0).getCustomerId().equals(customer.getCustomerId()))) {
            return true;
        }
        return false;
    }

    public static int create(Customer customer) {
        validateFields(customer);
        CustomerCRUD.create(customer);
        customer.setCustomerId(computeCustomerId(customer));
        CustomerCRUD.update(customer);//????
        return customer.getCustomerId();
    }

    private static Integer computeCustomerId(Customer customer) {
        return customer.getId();
    }


    public static void update(Customer customer) {
        validateFields(customer);
        CustomerCRUD.update(customer);
    }

    public static void delete(Integer customerId) {
        CustomerCRUD.delete(customerId);
    }

    public static List<Customer> retrieveInfo(Integer customerId) {
        List<Customer> customerList = read(null, null, customerId.toString(), null);
        if (customerList.size() == 0) {
            throw new InValidCustomerIdException("شماره ی مشتری اشتباه است.");
        }
        return customerList;
    }

    public static List<Customer> read(String firstName, String lastName, String customerId, String nationalId) {
        return CustomerCRUD.read(firstName, lastName, customerId, nationalId);
    }
}
