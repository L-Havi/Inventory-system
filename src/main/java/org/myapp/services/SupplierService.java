package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Supplier;
import org.myapp.model.Product;
import org.myapp.dao.SupplierDAO;
import org.myapp.dao.ProductDAO;

public class SupplierService {

  private SupplierDAO supplierDAO = new SupplierDAO();
  private ProductDAO productDAO = new ProductDAO();

  public List<Supplier> listSuppliers() throws ApplicationException {
    try {
      List<Supplier> suppliers = supplierDAO.getSuppliers();
      return suppliers;
    } catch (Exception e) {
      System.out.println("listing suppliers failed");
      throw new ApplicationException("listing suppliers failed");
    }
  }

  public void addSupplier(String supplierName, String supplierAddress, Integer supplierPhone, String supplierEmail) throws ApplicationException {
    if (supplierName == null || supplierAddress == null || supplierPhone == null || supplierEmail == null) {
      throw new ApplicationException("All fields are required");
    }
    Supplier supplier = new Supplier();
    supplier.setSupplierName(supplierName);
    supplier.setSupplierAddress(supplierAddress);
    supplier.setSupplierPhone(supplierPhone);
    supplier.setSupplierEmail(supplierEmail);
    supplierDAO.addSupplier(supplier);
  }

  public void deleteSupplier(Long supplierId) throws ApplicationException {
    if (supplierId < 0) {
      throw new ApplicationException("Supplier id must be positive");
    }
    try {
      Supplier supplierToBeDeleted = supplierDAO.getSupplierById(supplierId);
      if (supplierToBeDeleted == null) {
        throw (new ApplicationException("Supplier was not found."));
      }
      List<Product> products = productDAO.getProductsBySupplierId(supplierId);
      if (products != null && products.size() > 0) {
        for (Product product : products) {
          productDAO.deleteProduct(product);
        }
      }
      supplierDAO.deleteSupplier(supplierToBeDeleted.getSupplierId());
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the supplier failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the supplier failed: Unknown error"));
    }
    System.out.println("Supplier is deleted");
  }

}
