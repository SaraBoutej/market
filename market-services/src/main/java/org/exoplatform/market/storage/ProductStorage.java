package org.exoplatform.market.storage;

import org.exoplatform.market.dto.Product;
import org.exoplatform.market.dao.ProductDAO;
import org.exoplatform.market.entity.ProductEntity;
import org.exoplatform.market.util.EntityMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStorage {

  private ProductDAO productDao;

  public ProductStorage(ProductDAO productDao) {
    this.productDao = productDao;
  }

  public List<Product> getAllProduct() {
    List<ProductEntity> productEntities = productDao.findAll();
    return productEntities == null ? Collections.emptyList()
        : productEntities.stream().map(productEntity -> EntityMapper.fromEntity(productEntity))
            .collect(Collectors.toList());
  }

}
