package org.myapp.dao;

import org.myapp.model.Customer;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class CustomerDAO {


  public void addCustomer(Customer customer) throws ApplicationException {
    try {
      customer.save();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the customer failed"));
    }
  }

  public Customer getCustomerById(Long customer_id) throws ApplicationException {
    try {
      return DB.find(Customer.class).where(Expr.eq("customer_id", customer_id)).findOne();
    } catch (Exception e) {
      throw (new ApplicationException("Getting customer " + customer_id + " failed."));
    }
  }

  public List<Customer> getCustomers() throws ApplicationException {
    try {
      List<Customer> customers = DB.find(Customer.class).findList();
      return customers;
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Listing customers failed"));
    }
  }

  public void deleteCustomer(Long customer_id) throws ApplicationException {
    try {
      Customer customerToBeDeleted = DB.find(Customer.class).where(Expr.eq("customer_id", customer_id)).findOne();
      if (customerToBeDeleted == null) {
        throw (new ApplicationException("Customer was not found."));
      }
      customerToBeDeleted.delete();
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the customer failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the customer failed: Unknown error"));
    }
  }
}