package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Customer;
import org.myapp.model.Staff;
import org.myapp.model.Order;
import org.myapp.dao.CustomerDAO;
import org.myapp.dao.StaffDAO;
import org.myapp.dao.OrderDAO;

public class CustomerService {

  private CustomerDAO customerDAO = new CustomerDAO();
  private StaffDAO staffDAO = new StaffDAO();
  private OrderDAO orderDAO = new OrderDAO();

  public List<Customer> listCustomers() throws ApplicationException {
    try {
      List<Customer> customers = customerDAO.getCustomers();
      return customers;
    } catch (Exception e) {
      System.out.println("listing customers failed");
      throw new ApplicationException("listing customers failed");
    }
  }

  public void addCustomer(String firstName, String lastName, String customerAddress, Integer customerPhone, String customerEmail, Long staffId) throws ApplicationException {
    if (firstName == null || lastName == null || customerAddress == null || customerPhone == null || customerEmail == null || staffId == null) {
      throw new ApplicationException("All fields are required");
    }
    Staff customerStaff = staffDAO.getStaffById(staffId);
    Customer customer = new Customer();
    customer.setFirstName(firstName);
    customer.setLastName(lastName);
    customer.setCustomerAddress(customerAddress);
    customer.setCustomerPhone(customerPhone);
    customer.setCustomerEmail(customerEmail);
    customer.setStaff(customerStaff);
    customerDAO.addCustomer(customer);
  }

  public void deleteCustomer(Long customerId) throws ApplicationException {
    if (customerId < 0) {
      throw new ApplicationException("Customer id must be positive");
    }
    try {
      Customer customerToBeDeleted = customerDAO.getCustomerById(customerId);
      if (customerToBeDeleted == null) {
        throw (new ApplicationException("Customer was not found."));
      }
      List<Order> orders = orderDAO.getOrdersByCustomerId(customerId);
      // Avoid nullpointer exception and check null, before using the variable.
      if (orders != null && orders.size() > 0) {
        for (Order order : orders) {
          orderDAO.deleteOrder(order);
        }
      }
      customerDAO.deleteCustomer(customerToBeDeleted.getCustomerId());
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the customer failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the customer failed: Unknown error"));
    }
    System.out.println("Customer is deleted");
  }

}