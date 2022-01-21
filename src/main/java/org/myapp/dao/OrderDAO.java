package org.myapp.dao;

import org.myapp.model.Order;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class OrderDAO {


  public void addOrder(Order order) throws ApplicationException {
    try {
      order.save();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the order failed"));
    }
  }



  public Order getOrderById(Long order_id) throws ApplicationException {
    try {
      return DB.find(Order.class).where(Expr.eq("order_id", order_id)).findOne();
    } catch (Exception e) {
      throw (new ApplicationException("Getting order " + order_id + " failed."));
    }
  }

  public void deleteOrder(Long order_id) throws ApplicationException {
    try {
      Order orderToBeDeleted = DB.find(Order.class).where(Expr.eq("order_id", order_id)).findOne();
      if (orderToBeDeleted == null) {
        throw (new ApplicationException("Order was not found."));
      }
      orderToBeDeleted.delete();
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the order failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the order failed: Unknown error"));
    }
  }

  public List<Order> getOrders() throws ApplicationException {
    try {
      List<Order> orders = DB.find(Order.class).findList();
      return orders;
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Listing orders failed"));
    }
  }

 public void deleteOrder(Order order) throws ApplicationException {
    try {
      order.delete();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Saving the order failed"));
    }
  }

  public List<Order> getCustomerOrders(Long customerId) throws ApplicationException {
    try {
      return DB.find(Order.class).where(Expr.eq("customer_id", customerId)).findList();
    } catch (Exception e) {
      System.out.println("Getting orders failed: " + e.getMessage());
      throw (new ApplicationException("Getting orders failed."));
    }
  }

  public List<Order> getOrdersByCustomerId(Long customerId) throws ApplicationException {
    try {
      return DB.find(Order.class).where(Expr.eq("customer_id", customerId)).findList();
    } catch (Exception e) {
      System.out.println("Getting orders for customer failed: " + e.getMessage());
      throw (new ApplicationException("Getting orders failed."));
    }
  }
}