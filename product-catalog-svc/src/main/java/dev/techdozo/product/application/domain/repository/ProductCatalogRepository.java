package dev.techdozo.product.application.domain.repository;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.application.query.model.QueryParameter;

import java.util.List;

/** Domain repository for the product catalog. */
public interface ProductCatalogRepository {
  Long save(Product product);

  Product get(Long productId);

  List<Product> getAll(QueryParameter queryParameter);

  void delete(Long productId);
}
