package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Supplier;
import org.myapp.model.Product;
import org.myapp.model.Order;
import org.myapp.dao.SupplierDAO;
import org.myapp.dao.ProductDAO;
import org.myapp.dao.OrderDAO;

public class ProductService {

  private SupplierDAO supplierDAO = new SupplierDAO();
  private ProductDAO productDAO = new ProductDAO();
  private OrderDAO orderDAO = new OrderDAO();

  public List<Product> listProducts() throws ApplicationException {
    try {
      List<Product> products = productDAO.getProducts();
      return products;
    } catch (Exception e) {
      System.out.println("listing products failed");
      throw new ApplicationException("listing products failed");
    }
  }

  public void addProduct(String productName, String productDescription, Integer productQuantity, Long supplierId) throws ApplicationException {
    if (productName == null || productDescription == null || productQuantity == null || supplierId == null) {
      throw new ApplicationException("All fields are required");
    }
    Supplier supplierForProduct = supplierDAO.getSupplierById(supplierId);    
    Product product = new Product();
    product.setProductName(productName);
    product.setProductDescription(productDescription);
    product.setProductQuantity(productQuantity);
    product.setSupplier(supplierForProduct);
    productDAO.addProduct(product);
  }

  public void deleteProduct(Long productId) throws ApplicationException {
    if (productId < 0) {
      throw new ApplicationException("Product id must be positive");
    }
    try {
      Product productToBeDeleted = productDAO.getProductById(productId);
      if (productToBeDeleted == null) {
        throw (new ApplicationException("Product was not found."));
      }
      productDAO.deleteProduct(productToBeDeleted.getProductId());
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the product failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the product failed: Unknown error"));
    }
    System.out.println("Product is deleted");
  }

  public List<Product> listSupplierProducts(Long supplierId) throws ApplicationException {
    try {
      List<Product> products = productDAO.getSupplierProducts(supplierId);
      return products;
    } catch (Exception e) {
        System.out.println("listing supplier products failed");
        throw (new ApplicationException("listing supplier products failed."));
    }
  }
}