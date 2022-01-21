package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;


@Entity
public class Supplier extends Model {

  @Id
  Long supplier_id;

  String supplierName;
  String supplierAddress;
  Integer supplierPhone;
  String supplierEmail;

  @Version  
  Long lastUpdate;  

  public Supplier() {
  }

  public Long getSupplierId() {
    return supplier_id;
  }

  public void setSupplierId(Long supplier_id) {
    this.supplier_id = supplier_id;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getSupplierAddress() {
    return supplierAddress;
  }

  public void setSupplierAddress(String supplierAddress) {
    this.supplierAddress = supplierAddress;
  }

  public Integer getSupplierPhone() {
    return supplierPhone;
  }

  public void setSupplierPhone(Integer supplierPhone) {
    this.supplierPhone = supplierPhone;
  }

  public String getSupplierEmail() {
    return supplierEmail;
  }

  public void setSupplierEmail(String supplierEmail) {
    this.supplierEmail = supplierEmail;
  }

  public Long getLastUpdate() {  
    return lastUpdate;  
  }  
  
  public void setLastUpdate(Long lastUpdate) {  
    this.lastUpdate = lastUpdate;  
  }  

  public String toString() {
    return "Id:\t" + this.supplier_id + "\nName:\t" + this.supplierName + "\nAddress:\t" + this.supplierAddress + "\nPhone:\t" + this.supplierPhone + "\nEmail:\t" + this.supplierEmail;
  }

}
