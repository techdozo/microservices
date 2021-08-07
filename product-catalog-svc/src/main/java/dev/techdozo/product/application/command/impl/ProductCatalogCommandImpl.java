package dev.techdozo.product.application.command.impl;

import dev.techdozo.product.application.command.ProductCatalogCommand;
import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.application.domain.model.ProductCatalog;
import dev.techdozo.product.application.domain.repository.ProductCatalogRepository;

public class ProductCatalogCommandImpl implements ProductCatalogCommand {
  private final ProductCatalogRepository productCatalogRepository;

  public ProductCatalogCommandImpl(ProductCatalogRepository productCatalogRepository) {
    this.productCatalogRepository = productCatalogRepository;
  }

  @Override
  public Long addProduct(Product product) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    return productCatalog.addProduct(product);
  }

  @Override
  public void deleteProduct(Long productId) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    productCatalog.deleteProduct(productId);
  }

  @Override
  public void publish(Long productId) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    productCatalog.publish(productId);

  }

  @Override
  public Long updateProduct(Product product) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    return productCatalog.updateProduct(product);
  }
}
