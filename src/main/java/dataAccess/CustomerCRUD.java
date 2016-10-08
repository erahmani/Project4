package dataAccess;

import dataAccess.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

public class CustomerCRUD extends Main{


    public static void deleteCustomer(String customerId) {
        Connection conn = null;//DB.connectDB();
        String sql = "delete from bank.customer where customerId = " + customerId;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRealCustomer(Customer customer) {
        Connection conn = null;//DB.connectDB();
        try {
            String queryStr = "insert into realcustomer(firstName, lastName, fatherName, birthDay, nationalId) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(queryStr, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            customer.setCustomerId(Integer.toString(rs.getInt(1)));

            PreparedStatement preparedStatement = conn.prepareStatement(queryStr);
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getFatherName());
            preparedStatement.setString(5, customer.getBirthDay());
            preparedStatement.setString(6, customer.getNationalId());
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<Customer> prepareRealCustomerSelectResult(ResultSet resultSet) {
        LinkedList<Customer> customerList = new LinkedList();
        try {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setFatherName(resultSet.getString("fatherName"));
                customer.setBirthDay(resultSet.getString("birthDay"));
                customer.setNationalId(resultSet.getString("nationalId"));
                customer.setCustomerId(resultSet.getString("customerId"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static LinkedList<Customer> selectRealCustomer(String searchOption, String searchValue) {
        Connection conn = null;//DB.connectDB();
        LinkedList<Customer> customerList = null;
        try {
            String queryStr = "SELECT * FROM realcustomer WHERE " + searchOption + " = '" + searchValue + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(queryStr);
            ResultSet resultSet = preparedStatement.executeQuery(queryStr);
            if (resultSet != null) {
                customerList = prepareRealCustomerSelectResult(resultSet);
            }
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void updateRealCustomer(Customer customer) {
        try {
            Connection conn = null;//DB.connectDB();
            String queryStr = "UPDATE RealCustomer SET firstName=?, lastName=?, fatherName=?, birthDay=?, nationalId=? WHERE customerId = " + customer.getCustomerId();
            PreparedStatement stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getFatherName());
            stmt.setString(4, customer.getBirthDay());
            stmt.setString(5, customer.getNationalId());

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
