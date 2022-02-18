package org.exoplatform.market.service.impl;

import java.util.List;

import org.exoplatform.market.dto.Product;
import org.exoplatform.market.service.ProductService;
import org.exoplatform.market.storage.ProductStorage;

public class ProductServiceImpl implements ProductService{

  private ProductStorage productStorage;

  public ProductServiceImpl(ProductStorage productStorage) {
    this.productStorage = productStorage;
  }

  @Override
  public List<Product> getAllProducts() throws Exception {
      return productStorage.getAllProduct();
  }
  
}
