package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.ManyToMany;

@Entity
public class Order extends Model {

  @Id
  Long order_id;

  Integer orderQuantity;

  @ManyToOne
  Customer customer;

  @ManyToMany
  Product product;

  @Version  
  Long lastUpdate;  

  @Transient
  String orderDate;

  public Order() {
  }

  public Long getOrderId() {
    return order_id;
  }

  public void setOrderId(Long order_id) {
    this.order_id = order_id;
  }

  public Integer getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderQuantity(Integer orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Long getLastUpdate() {  
    return lastUpdate;  
  }  
  
  public void setLastUpdate(Long lastUpdate) {  
    this.lastUpdate = lastUpdate;  
  }  

  public String toString() {
    return "Id:\t" + this.order_id + "\nOrder Quantity:\t" + this.orderQuantity + "\nOrder Date:\t" + this.orderDate + "\nOrder Customer:\t" + this.customer + "\nOrder Product:\t" + this.product;
  }

}
