package org.exoplatform.market.service;

import org.exoplatform.market.dto.Product;

import java.util.List;

public interface ProductService {

  /**
   * Get List of all products
   * @return {@link List} of {@link Product}
   * @throws Exception
   */
  List<Product> getAllProducts() throws Exception;
  
}
