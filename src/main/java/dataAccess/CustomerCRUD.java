package dataAccess;

import dataAccess.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerCRUD {

    public static void create(Customer customer) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Customer> read(String firstName, String lastName, String customerId, String nationalId) {
        List<Customer> customerList = new ArrayList<Customer>();
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println(firstName + " " + lastName + " " + customerId + " " + nationalId);
            Query query = session.createQuery("FROM Customer Where " +
                    "((:firstName is null or trim(:firstName) = '' or firstName=:firstName)" +
                    "and(:lastName is null or trim(:lastName) = '' or lastName=:lastName) " +
                    "and(:customerId is null or trim(:customerId) = '' or customerId=:customerId)" +
                    "and(:nationalId is null or trim(:nationalId) = '' or nationalId=:nationalId))");
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("customerId", customerId);
            query.setParameter("nationalId", nationalId);
            customerList = query.list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            return customerList;
        }
    }

    public static void update(Customer customer) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Customer customer_new = (Customer) session.get(Customer.class, customer.getCustomerId());
            customer_new.setFirstName(customer.getFirstName());
            customer_new.setLastName(customer.getLastName());
            customer_new.setFatherName(customer.getFatherName());
            customer_new.setBirthDay(customer.getBirthDay());
            customer_new.setNationalId(customer.getNationalId());
            customer_new.setCustomerId(customer.getCustomerId());
            session.update(customer_new);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Integer id) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Customer customer = (Customer) session.get(Customer.class, id);
            session.delete(customer);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
