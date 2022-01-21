package org.myapp;

import org.myapp.utils.InputScanner;


import org.myapp.services.CustomerService;
import org.myapp.services.OrderService;
import org.myapp.services.ProductService;
import org.myapp.services.StaffService;
import org.myapp.services.SupplierService;

import java.util.List;

import org.myapp.model.Customer;
import org.myapp.model.Order;
import org.myapp.model.Product;
import org.myapp.model.Staff;
import org.myapp.model.Supplier;

import org.myapp.utils.DateTimeUtils;
import org.myapp.ApplicationException;


public class InputScannerApp {

  private static CustomerService customerService = new CustomerService();
  private static OrderService orderService = new OrderService();
  private static ProductService productService = new ProductService();
  private static StaffService staffService = new StaffService();
  private static SupplierService supplierService = new SupplierService();

  private static InputScanner scanner = new InputScanner();

  static String info = "Type: (use enter after input)\n\n";

  public void startApp(String[] args) {
    System.out.println(info + " addsupplier | deletesupplier | suppliers | staff | addcustomer |\n deletecustomer | customers | order | deleteorder | orders |\n orderbycustomerid | addproduct | deleteproduct | products | productbysupplierid");
    try {
      if (args.length == 0) {
        args = scanner.scanArguments(1);
        if (args[0].equals("addsupplier")) {
          addSupplier();
        } else if (args[0].equals("deletesupplier")) {
          deleteSupplier();
        } else if (args[0].equals("suppliers")) {
          listSuppliers();
        } else if (args[0].equals("staff")) {
          listStaff();
        } else if (args[0].equals("addcustomer")) {
          addCustomer();
        } else if (args[0].equals("deletecustomer")) {
          deleteCustomer();
        } else if (args[0].equals("customers")) {
          listCustomers();
        } else if (args[0].equals("order")) {
          order();
        } else if (args[0].equals("deleteorder")) {
          deleteOrder();
        } else if (args[0].equals("orders")) {
          listOrders();
        } else if (args[0].equals("orderbycustomerid")) {
          orderByCustomerID();
        } else if (args[0].equals("addproduct")) {
          addProduct();
        } else if (args[0].equals("deleteproduct")) {
          deleteProduct();
        } else if (args[0].equals("products")) {
          listProducts();
        } else if (args[0].equals("productbysupplierid")) {
          productBySupplierID();
        } else {
          System.out.println("Nothing selected.");
        }
      }
    } catch (Exception e) {
      System.out.println("Error! " + e.getMessage());
      }
  }

  private static void addSupplier() throws ApplicationException {
    System.out.println(info + "Supplier name[enter]\nSupplier address[enter]\nSupplier phone[enter]\nSupplier email[enter]\n");
    String[] args = scanner.scanArguments(4);
    if (args.length == 4) {
      try {
        Integer phone = Integer.parseInt(args[2]);
        supplierService.addSupplier(args[0], args[1], phone, args[3]);
        System.out.println("Supplier is saved");
      } catch (NumberFormatException nfe) {
        System.out.println("Phone number should be an integer");
      }
      
    }
  }

  private static void deleteSupplier() throws ApplicationException {
    System.out.println("Supplier number is positive integer");
    String args[] = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long supplierId = Long.parseLong(args[0]);
        supplierService.deleteSupplier(supplierId);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
  }

  private void listSuppliers() {
    try {
      List<Supplier> suppliers = supplierService.listSuppliers();
      System.out.println("---------------------------------\n");
      for (Supplier supplier : suppliers) {
        System.out.println("Supplier no\t" + supplier.getSupplierId() + "\nSupplier name\t" + supplier.getSupplierName() + "\n");
        System.out.println("Supplier address\t" + supplier.getSupplierAddress() + "\n");
        System.out.println("Supplier Phone\t" + supplier.getSupplierPhone() + "\n");
        System.out.println("Supplier Email\t" + supplier.getSupplierEmail() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing suppliers failed");
    }
  }

  private void listStaff() {
    try {
      List<Staff> employees = staffService.listStaff();
      System.out.println("---------------------------------\n");
      for (Staff staff : employees) {
        System.out.println("Staff no\t" + staff.getStaffId() + "\nFirst name\t" + staff.getFirstName() + "\nLast name\t" + staff.getLastName());
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing suppliers failed");
    }
  }

  private static void addCustomer() throws ApplicationException {
    System.out.println(info + "Customer first name[enter]\nCustomer last name[enter]\nCustomer address[enter]\nCustomer phone[enter]\nCustomer email[enter]\nStaff Id[enter]\n");
    String[] args = scanner.scanArguments(6);
    if (args.length == 6) {
      try {
        Integer phone = Integer.parseInt(args[3]);
        long staffId = Long.parseLong(args[5]);
        customerService.addCustomer(args[0], args[1], args[2], phone, args[4], staffId);
        System.out.println("Customer is saved");
      } catch (NumberFormatException nfe) {
        System.out.println("Phone number should be an integer");
      }
      
    }
  }

  private static void deleteCustomer() throws ApplicationException {
    System.out.println("Customer number is positive integer");
    String args[] = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long customerId = Long.parseLong(args[0]);
        customerService.deleteCustomer(customerId);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
  }

  private void listCustomers() {
    try {
      List<Customer> customers = customerService.listCustomers();
      System.out.println("---------------------------------\n");
      for (Customer customer : customers) {
        System.out.println("Customer no\t" + customer.getCustomerId() + "\nFirst name\t" + customer.getFirstName() + "\nLast name\t" + customer.getLastName() +"\n");
        System.out.println("Customer address\t" + customer.getCustomerAddress() + "\n");
        System.out.println("Customer Phone\t" + customer.getCustomerPhone() + "\n");
        System.out.println("Customer Email\t" + customer.getCustomerEmail() + "\n");
        System.out.println("Employee in charge\t" + customer.getStaff() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing customers failed");
    }
  }

    private static void order() throws ApplicationException {
    System.out.println(info + "[enter]\nOrder date in format YYYY-MM-DD [enter]\nProduct Id[enter]\nOrder quantity[enter]\nCustomer Id[enter]\n");
    String[] args = scanner.scanArguments(4);
    if (args.length == 4) {
      try {
        Integer orderQuantity = Integer.parseInt(args[2]);
        long customerId = Long.parseLong(args[3]);
        long productId = Long.parseLong(args[1]);
        orderService.addOrder(args[0], productId, orderQuantity, customerId);
        System.out.println("Order is saved");
      } catch (NumberFormatException nfe) {
        System.out.println("Order quantity should be an integer");
      }
      
    }
  }

  private static void deleteOrder() throws ApplicationException {
    System.out.println("Order number is positive integer");
    String args[] = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long orderId = Long.parseLong(args[0]);
        orderService.deleteOrder(orderId);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
  }

  private void listOrders() {
    try {
      List<Order> orders = orderService.listOrders();
      System.out.println("---------------------------------\n");
      for (Order order : orders) {
        System.out.println("Order no\t" + order.getOrderId() + "\n");
        System.out.println("Order date\t" + order.getOrderDate() + "\n");
        System.out.println("Product Id\t" + order.getProduct() + "\n");
        System.out.println("Order quantity\t" + order.getOrderQuantity() + "\n");
        System.out.println("Customer Id\t" + order.getCustomer() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing orders failed");
    }
  }

  private static void orderByCustomerID() throws ApplicationException {
    System.out.println(info +"customerid[enter]\n");
    String[] args = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long orderId = Long.parseLong(args[0]);
        orderService.listCustomerOrders(orderId);
      } catch (NumberFormatException nfe) {
        System.out.println("Order number is positive integer");
      }
    }
  }

    private static void addProduct() throws ApplicationException {
    System.out.println(info + "[enter]\nProduct name[enter]\nProduct description[enter]\nProduct quantity[enter]\nSupplier Id[enter]\n");
    String[] args = scanner.scanArguments(4);
    if (args.length == 4) {
      try {
        Integer productQuantity = Integer.parseInt(args[2]);
        long supplierId = Long.parseLong(args[3]);
        productService.addProduct(args[0], args[1], productQuantity, supplierId);
        System.out.println("Product is saved");
      } catch (NumberFormatException nfe) {
        System.out.println("Product quantity should be an integer");
      }
      
    }
  }

  private static void deleteProduct() throws ApplicationException {
    System.out.println("Product number is positive integer");
    String args[] = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long productId = Long.parseLong(args[0]);
        productService.deleteProduct(productId);
      } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
      }
    }
  }

  private void listProducts() {
    try {
      List<Product> products = productService.listProducts();
      System.out.println("---------------------------------\n");
      for (Product product : products) {
        System.out.println("Product no\t" + product.getProductId() + "\n");
        System.out.println("Product name\t" + product.getProductName() + "\n");
        System.out.println("Product description\t" + product.getProductDescription() + "\n");
        System.out.println("Product quantity\t" + product.getProductQuantity() + "\n");
        System.out.println("Supplier Id\t" + product.getSupplier() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing products failed");
    }
  }

  private static void productBySupplierID() throws ApplicationException {
    System.out.println(info +"supplierid[enter]\n");
    String[] args = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long supplierId = Long.parseLong(args[0]);
        productService.listSupplierProducts(supplierId);
      } catch (NumberFormatException nfe) {
        System.out.println("Supplier number is positive integer");
      }
    }
  }
}