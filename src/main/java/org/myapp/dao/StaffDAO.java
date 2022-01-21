package org.myapp.dao;

import org.myapp.model.Staff;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class StaffDAO {


  public void addStaff(Staff staff) throws ApplicationException {
    try {
      staff.save();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the staff failed"));
    }
  }

  public Staff getStaffById(Long staff_id) throws ApplicationException {
    try {
      return DB.find(Staff.class).where(Expr.eq("staff_id", staff_id)).findOne();
    } catch (Exception e) {
      throw (new ApplicationException("Getting employee " + staff_id + " failed."));
    }
  }

  public List<Staff> getStaff() throws ApplicationException {
    try {
      List<Staff> employees = DB.find(Staff.class).findList();
      return employees;
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Listing employees failed"));
    }
  }

  public void deleteStaff(Long staff_id) throws ApplicationException {
    try {
      Staff staffToBeDeleted = DB.find(Staff.class).where(Expr.eq("staff_id", staff_id)).findOne();
      if (staffToBeDeleted == null) {
        throw (new ApplicationException("Employee was not found."));
      }
      staffToBeDeleted.delete();
    } catch (ApplicationException e) {
      throw (new ApplicationException("Deleting the employee failed: " + e.getMessage()));
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Deleting the employee failed: Unknown error"));
    }
  }
}