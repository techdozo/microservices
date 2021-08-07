package dev.techdozo.product.application.query;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.application.query.model.QueryParameter;

import java.util.List;

public interface ProductCatalogQuery {
  Product getProduct(Long productId);
  List<Product> getProducts(QueryParameter queryParameter);
}
