package org.myapp.dao;

import org.myapp.model.Supplier;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class SupplierDAO {


  public void addSupplier(Supplier supplier) throws ApplicationException {
    try {
      supplier.save();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the supplier failed"));
    }
  }

  public Supplier getSupplierById(Long supplier_id) throws ApplicationException {
    try {
      return DB.find(Supplier.class).where(Expr.eq("supplier_id", supplier_id)).findOne();
    } catch (Exception e) {
      throw (new ApplicationException("Getting supplier " + supplier_id + " failed."));
    }
  }

  public List<Supplier> getSuppliers() throws ApplicationException {
    try {
      List<Supplier> suppliers = DB.find(Supplier.class).findList();
      return suppliers;
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Listing suppliers failed"));
    }
  }

  public void deleteSupplier(Long supplier_id) throws ApplicationException {
    try {
      Supplier supplierToBeDeleted = DB.find(Supplier.class).where(Expr.eq("supplier_id", supplier_id)).findOne();
      if (supplierToBeDeleted == null) {
        throw (new ApplicationException("Supplier was not found."));
      }
      supplierToBeDeleted.delete();
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the supplier failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the supplier failed: Unknown error"));
    }
  }
}