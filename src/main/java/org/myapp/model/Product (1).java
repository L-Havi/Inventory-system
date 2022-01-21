package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class Product extends Model {

  @Id
  Long product_id;

  String productName;
  String productDescription;
  Integer productQuantity;

  @ManyToOne
  Supplier supplier;

  @Version  
  Long lastUpdate;  

  public Product() {
  }

  public Long getProductId() {
    return product_id;
  }

  public void setProductId(Long product_id) {
    this.product_id = product_id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Integer getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(Integer productQuantity) {
    this.productQuantity = productQuantity;
  }

  public Supplier getSupplier() {
    return this.supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Long getLastUpdate() {  
    return lastUpdate;  
  }  
  
  public void setLastUpdate(Long lastUpdate) {  
    this.lastUpdate = lastUpdate;  
  }  

  public String toString() {
    return "Id:\t" + this.product_id + "\nName:\t" + this.productName + "\nDescription:\t" + this.productDescription + "\nQuantity:\t" + this.productQuantity + "\nSupplier:\t" + this.supplier;
  }
}
