package dev.techdozo.product.application.factory.impl;

import dev.techdozo.product.application.command.ProductCatalogCommand;
import dev.techdozo.product.application.factory.ProductCatalogFactory;
import dev.techdozo.product.application.query.ProductCatalogQuery;

public class ProductCatalogFactoryImpl implements ProductCatalogFactory {

  private final ProductCatalogCommand productCatalogCommand;
  private final ProductCatalogQuery productCatalogQuery;

  public ProductCatalogFactoryImpl(
      ProductCatalogCommand productCatalogCommand, ProductCatalogQuery productCatalogQuery) {
    this.productCatalogCommand = productCatalogCommand;
    this.productCatalogQuery = productCatalogQuery;
  }

  @Override
  public ProductCatalogCommand getProductCatalogCommand() {
    return productCatalogCommand;
  }

  @Override
  public ProductCatalogQuery getProductQuery() {
    return productCatalogQuery;
  }
}
