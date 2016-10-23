package businessLogic.customer;

import businessLogic.customer.exception.InValidCustomerFieldException;
import businessLogic.customer.exception.InValidCustomerIdException;
import dataAccess.CustomerCRUD;
import dataAccess.entity.Customer;
import log4j.Log;

import java.util.List;

public class CustomerBusinessLogic {
    private static void validateFields(Customer customer) {
        String errorMessage = "";
        boolean inValidField = false;
        if (customer.getFirstName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "نام وارد نشده است!\n";
        }
        if (customer.getLastName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "نام خانوادگی وارد نشده است!\n";
        }
        if (customer.getFatherName().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "نام پدر وارد نشده است!\n";
        }
        if (customer.getBirthDay().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "تاریخ تولد وارد نشده است!\n";
        }
        if (customer.getNationalId().trim().isEmpty()) {
            inValidField = true;
            errorMessage += "کد ملی وارد نشده است!\n";
        }
        if (inValidField) {
            Log.log.error("مشکل در ثبت نام مشتری جدید" + errorMessage);
            throw new InValidCustomerFieldException(errorMessage);
        }
        validateNationalId(customer);
    }

    private static void validateNationalId(Customer customer) {
        if (!isNationalIdValid(customer.getNationalId())) {
            Log.log.error("مشکل در ثبت نام مشتری جدید:  کد ملی وارد شده صحیح نمیباشد.");
            throw new InValidCustomerFieldException("کد ملی وارد شده صحیح نمیباشد.");
        }
        if (!isNationalIdUnique(customer)) {
            Log.log.error("مشکل در ثبت نام مشتری جدید کد ملی وارد شده تکراری است.");
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
            return check % 11 == Integer.parseInt(nationalId.substring(nationalId.length() - 1, nationalId.length()))
                    || check % 11 == 11 - Integer.parseInt(nationalId.substring(nationalId.length() - 1, nationalId.length()));
        }
    }

    private static boolean isNationalIdUnique(Customer customer) {
        List<Customer> customerList = read(null, null, null, customer.getNationalId());
        return (customerList.size() == 0) || (customerList.size() == 1 && customerList.get(0).getCustomerId().equals(customer.getCustomerId()));
    }

    public static int create(Customer customer) {
        validateFields(customer);
        CustomerCRUD.create(customer);
        customer.setCustomerId(computeCustomerId(customer));
        CustomerCRUD.update(customer);//????
        Log.log.info("ایجاد مشتری با شماره ی: " + customer.getCustomerId());
        return customer.getCustomerId();
    }

    private static Integer computeCustomerId(Customer customer) {
        return customer.getId();
    }


    public static void update(Customer customer) {
        validateFields(customer);
        Log.log.info("بروز رسانی مشتری با شماره ی: " + customer.getCustomerId());
        CustomerCRUD.update(customer);
    }

    public static void delete(Integer customerId) {
        Log.log.info("حذف مشتری با شماره ی: " + customerId);
        CustomerCRUD.delete(customerId);
    }

    public static List<Customer> retrieveInfo(Integer customerId) {
        if (customerId == null) {
            Log.log.error("بازیابی اطلاعاتی مشتری: شماره ی مشتری وارد نشده است.");
            throw new InValidCustomerIdException("شماره ی مشتری وارد نشده است.");
        }

        List<Customer> customerList = read(null, null, customerId.toString(), null);
        if (customerList.size() == 0) {
            Log.log.error("بازیابی اطلاعاتی مشتری: شماره ی مشتری اشتباه است.");
            throw new InValidCustomerIdException("شماره ی مشتری اشتباه است.");
        }
        Log.log.info("بازیابی اطلاعات مشتری با شماره ی: " + customerList.get(0).getCustomerId());
        return customerList;
    }

    public static List<Customer> read(String firstName, String lastName, String customerId, String nationalId) {
        Log.log.info("جستجوی اطلاعات مشتری با شماره مشتری: " + customerId);
        return CustomerCRUD.read(firstName, lastName, customerId, nationalId);
    }
}
