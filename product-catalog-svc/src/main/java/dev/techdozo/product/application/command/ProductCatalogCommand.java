package dev.techdozo.product.application.command;

import dev.techdozo.product.application.domain.model.Product;

public interface ProductCatalogCommand {
  Long addProduct(Product product);

  void deleteProduct(Long productId);

  void publish(Long productId);

  Long  updateProduct(Product product);
}
