package dataAccess;

import dataAccess.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerCRUD {

    public static int create(Customer customer) {
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
            return customer.getCustomerId();
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

    public static ArrayList<Customer> selectFirstName(String firstName) {
        List<Customer> customerList = new ArrayList<Customer>();
        System.out.println(1);
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            customerList = session.createQuery("FROM Customer Where firstName = '" + firstName +"'").list();
            transaction.commit();
            System.out.println(2);
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(3);
            ex.printStackTrace();
        } finally {
            System.out.println(4);
            session.close();
        }
        System.out.println(5);
        return (ArrayList<Customer>) customerList;
    }

    public static ArrayList<Customer> selectLastName(String lastName) {
        List<Customer> customerList = new ArrayList<Customer>();
        System.out.println(1);
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            customerList = session.createQuery("FROM Customer Where lastName = '" + lastName  +"'").list();
            transaction.commit();
            System.out.println(2);
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(3);
            ex.printStackTrace();
        } finally {
            System.out.println(4);
            session.close();
        }
        System.out.println(5);
        return (ArrayList<Customer>) customerList;
    }

    public static ArrayList<Customer> selectNationalId(String nationalId) {
        List<Customer> customerList = new ArrayList<Customer>();
        System.out.println(1);
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            customerList = session.createQuery("FROM Customer Where nationalId = '" + nationalId + "'").list();
            transaction.commit();
            System.out.println(2);
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(3);
            ex.printStackTrace();
        } finally {
            System.out.println(4);
            session.close();
        }
        System.out.println(5);
        return (ArrayList<Customer>) customerList;
    }

    public static ArrayList<Customer> searchCustomerId(String customerId) {
        List<Customer> customerList = new ArrayList<Customer>();
        System.out.println(1);
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            customerList = session.createQuery("FROM Customer Where customerId = " + customerId).list();
            transaction.commit();
            System.out.println(2);
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(3);
            ex.printStackTrace();
        } finally {
            System.out.println(4);
            session.close();
        }
        System.out.println(5);
        return (ArrayList<Customer>) customerList;
    }
}
