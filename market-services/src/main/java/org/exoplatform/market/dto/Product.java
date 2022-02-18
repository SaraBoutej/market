package org.exoplatform.market.dto;

import org.exoplatform.market.util.UserInfo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Cloneable{

  private long id;

  private long code;

  private String name;

  private long unitPrice;

  private int quantity;

  private UserInfo userInfo;

  @Override
  public Product clone() { // NOSONAR
    return new Product(id, code, name, unitPrice, quantity, userInfo);
  }

}
