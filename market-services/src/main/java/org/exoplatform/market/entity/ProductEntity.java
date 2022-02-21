package org.exoplatform.market.entity;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity(name = "marketProductEntity")
@ExoEntity
@Table(name = "EXO_MARKET_PRODUCT")
public class ProductEntity implements Serializable{

  private static final long serialVersionUID = 5666518670268932967L;
  @Id
  @Column(name = "PRODUCT_ID")
  private Long id;

  @Column(name = "PRODUCT_CODE")
  private Long code;

  @Column(name = "PRODUCT_NAME")
  private String name;

  @Column(name = "PRODUCT_UNIT_PRICE")
  private Long unitPrice;

  @Column(name = "PRODUCT_QUANTITY")
  private Integer quantity;

  @Column(name = "PRODUCT_DATE")
  private Date date;

  @Column(name = "PRODUCT_OWNER")
  private String owner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Long unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}
