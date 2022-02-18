package org.exoplatform.market.util;

import org.exoplatform.market.entity.ProductEntity;
import org.exoplatform.social.core.identity.provider.OrganizationIdentityProvider;
import org.exoplatform.market.dto.Product;

public class EntityMapper {

  private EntityMapper() {
  }

  public static ProductEntity toEntity(Product product) {
    if (product == null) {
      return null;
    }

    ProductEntity productEntity = new ProductEntity();

    productEntity.setCode(product.getCode());
    productEntity.setName(product.getName());
    productEntity.setOwner(product.getUserInfo().getId());
    productEntity.setQuantity(product.getQuantity());
    productEntity.setUnitPrice(product.getUnitPrice());

    return productEntity;
  }

  public static Product fromEntity (ProductEntity productEntity ) {

    Product product = new Product();
    product.setCode(productEntity.getCode());
    product.setName(productEntity.getName());
    product.setQuantity(productEntity.getQuantity());
    product.setUnitPrice(productEntity.getQuantity());
    product.setUserInfo(Utils.getUserInfo(Utils.getIdentityByTypeAndId(OrganizationIdentityProvider.NAME,
            Utils.getCurrentUser())));
    return product;
  }
}
