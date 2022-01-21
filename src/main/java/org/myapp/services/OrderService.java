package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Order;
import org.myapp.model.Product;
import org.myapp.model.Customer;
import org.myapp.dao.CustomerDAO;
import org.myapp.dao.ProductDAO;
import org.myapp.dao.OrderDAO;

public class OrderService {

  private CustomerDAO customerDAO = new CustomerDAO();
  private ProductDAO productDAO = new ProductDAO();
  private OrderDAO orderDAO = new OrderDAO();

  public List<Order> listOrders() throws ApplicationException {
    try {
      List<Order> orders = orderDAO.getOrders();
      return orders;
    } catch (Exception e) {
      System.out.println("listing orders failed");
      throw new ApplicationException("listing orders failed");
    }
  }

  public void addOrder(String orderDate, Long productId, Integer orderQuantity, Long customerId) throws ApplicationException {
    if (orderDate == null || orderQuantity == null || productId == null || customerId == null) {
      throw new ApplicationException("All fields are required");
    }
    Product orderProduct = productDAO.getProductById(productId);
    Customer orderCustomer = customerDAO.getCustomerById(customerId);
    Order order = new Order();
    order.setOrderDate(orderDate);
    order.setOrderQuantity(orderQuantity);
    order.setProduct(orderProduct);
    order.setCustomer(orderCustomer);
    orderDAO.addOrder(order);
  }

  public void deleteOrder(Long orderId) throws ApplicationException {
    if (orderId < 0) {
      throw new ApplicationException("Order id must be positive");
    }
    try {
      Order orderToBeDeleted = orderDAO.getOrderById(orderId);
      if (orderToBeDeleted == null) {
        throw (new ApplicationException("Order was not found."));
      }
      orderDAO.deleteOrder(orderToBeDeleted.getOrderId());
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the order failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the order failed: Unknown error"));
    }
    System.out.println("Order is deleted");
  }

  public List<Order> listCustomerOrders(Long customerId) throws ApplicationException {
    try {
      List<Order> orders = orderDAO.getCustomerOrders(customerId);
      return orders;
    } catch (Exception e) {
        System.out.println("listing customer orders failed");
        throw (new ApplicationException("listing customer orders failed."));
    }
  }
}