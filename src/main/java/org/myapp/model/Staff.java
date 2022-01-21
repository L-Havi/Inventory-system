package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class Staff extends Model {

  @Id
  Long staff_id;

  String firstName;
  String lastName;

  @Version  
  Long lastUpdate;  

  public Staff() {
  }

  public Long getStaffId() {
    return staff_id;
  }

  public void setStaffId(Long staff_id) {
    this.staff_id = staff_id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getLastUpdate() {  
    return lastUpdate;  
  }  
  
  public void setLastUpdate(Long lastUpdate) {  
    this.lastUpdate = lastUpdate;  
  }  

  public String toString() {
    return "Id:\t" + this.staff_id + "\nFirst name:\t" + this.firstName + "\nLast name:\t" + this.lastName;
  }

}
