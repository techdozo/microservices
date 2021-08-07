package dev.techdozo.product.application.query.impl;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.application.domain.model.ProductCatalog;
import dev.techdozo.product.application.domain.repository.ProductCatalogRepository;
import dev.techdozo.product.application.query.ProductCatalogQuery;
import dev.techdozo.product.application.query.model.QueryParameter;

import java.util.List;

public class ProductCatalogQueryImpl implements ProductCatalogQuery {
  private final ProductCatalogRepository productCatalogRepository;

  public ProductCatalogQueryImpl(ProductCatalogRepository productCatalogRepository) {
    this.productCatalogRepository = productCatalogRepository;
  }

  @Override
  public Product getProduct(Long productId) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    return productCatalog.get(productId);
  }

  @Override
  public List<Product> getProducts(QueryParameter queryParameter) {
    var productCatalog = new ProductCatalog(productCatalogRepository);
    return productCatalog.getAll(queryParameter);
  }
}
