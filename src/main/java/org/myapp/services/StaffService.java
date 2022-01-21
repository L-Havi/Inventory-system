package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Staff;
import org.myapp.dao.StaffDAO;

public class StaffService {

  private StaffDAO staffDAO = new StaffDAO();

  public List<Staff> listStaff() throws ApplicationException {
    try {
      List<Staff> employees = staffDAO.getStaff();
      return employees;
    } catch (Exception e) {
      System.out.println("listing employees failed");
      throw new ApplicationException("listing employees failed");
    }
  }
}