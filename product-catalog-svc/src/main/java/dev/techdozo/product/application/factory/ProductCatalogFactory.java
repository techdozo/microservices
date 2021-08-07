package dev.techdozo.product.application.factory;

import dev.techdozo.product.application.command.ProductCatalogCommand;
import dev.techdozo.product.application.query.ProductCatalogQuery;

public interface ProductCatalogFactory {

  /**
   * returns product catalog command
   *
   * @return ProductCatalogCommand
   */
  ProductCatalogCommand getProductCatalogCommand();

  /**
   * returns product catalog query
   *
   * @return query
   */
  ProductCatalogQuery getProductQuery();
}
