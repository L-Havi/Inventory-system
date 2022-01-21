package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class Customer extends Model {

  @Id
  Long customer_id;

  String firstName;
  String lastName;
  String customerAddress;
  Integer customerPhone;
  String customerEmail;

  @ManyToOne
  Staff staff;

  @Version  
  Long lastUpdate;  

  public Customer() {
  }

  public Long getCustomerId() {
    return customer_id;
  }

  public void setCustomerId(Long customer_id) {
    this.customer_id = customer_id;
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

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public Integer getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(Integer customerPhone) {
    this.customerPhone = customerPhone;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public Staff getStaff() {
    return this.staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public Long getLastUpdate() {  
    return lastUpdate;  
  }  
  
  public void setLastUpdate(Long lastUpdate) {  
    this.lastUpdate = lastUpdate;  
  }  

  public String toString() {
    return "Id:\t" + this.customer_id + "\nFirst name:\t" + this.firstName + "\nLast name:\t" + this.lastName + "\nAddress:\t" + this.customerAddress + "\nPhone:\t" + this.customerPhone + "\nEmail:\t" + this.customerEmail + "\nRole:\t" + this.staff;
  }

}
