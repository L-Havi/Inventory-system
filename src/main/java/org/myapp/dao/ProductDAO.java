package org.myapp.dao;

import org.myapp.model.Product;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class ProductDAO {


  public void addProduct(Product product) throws ApplicationException {
    try {
      product.save();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the product failed"));
    }
  }

  public Product getProductById(Long product_id) throws ApplicationException {
    try {
      return DB.find(Product.class).where(Expr.eq("product_id", product_id)).findOne();
    } catch (Exception e) {
      throw (new ApplicationException("Getting product " + product_id + " failed."));
    }
  }

  public List<Product> getProducts() throws ApplicationException {
    try {
      List<Product> products = DB.find(Product.class).findList();
      return products;
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Listing products failed"));
    }
  }

  public List<Product> getProductsBySupplierId(Long supplierId) throws ApplicationException {
    try {
      return DB.find(Product.class).where(Expr.eq("supplier_id", supplierId)).findList();
    } catch (Exception e) {
      System.out.println("Getting products for supplier failed: " + e.getMessage());
      throw (new ApplicationException("Getting products failed."));
    }
  }

  public Product getProductBySupplierId(Long supplierId) throws ApplicationException {
    try {
      return DB.find(Product.class).where(Expr.eq("supplier_id", supplierId)).findOne();
    } catch (Exception e) {
      System.out.println("Getting products for supplier failed: " + e.getMessage());
      throw (new ApplicationException("Getting products failed."));
    }
  }

 public void deleteProduct(Product product) throws ApplicationException {
    try {
      product.delete();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Saving the product failed"));
    }
  }

  public void deleteProduct(Long product_id) throws ApplicationException {
    try {
      Product productToBeDeleted = DB.find(Product.class).where(Expr.eq("product_id", product_id)).findOne();
      if (productToBeDeleted == null) {
        throw (new ApplicationException("Product was not found."));
      }
      productToBeDeleted.delete();
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the product failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the product failed: Unknown error"));
    }
  }

  public List<Product> getSupplierProducts(Long supplierId) throws ApplicationException {
    try {
      return DB.find(Product.class).where(Expr.eq("supplier_id", supplierId)).findList();
    } catch (Exception e) {
      System.out.println("Getting supplier products failed: " + e.getMessage());
      throw (new ApplicationException("Getting supplier products failed."));
    }
  }

}