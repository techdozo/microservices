package dev.techdozo.product.application.domain.model;

import dev.techdozo.product.application.domain.repository.ProductCatalogRepository;
import dev.techdozo.product.application.query.model.QueryParameter;
import dev.techdozo.product.common.error.InvalidOperationException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductCatalog {

  private final ProductCatalogRepository productCatalogRepository;

  public Long addProduct(Product product) {
    // Add business validation
    product.setProductStatus(ProductStatus.DRAFT.name());
    return productCatalogRepository.save(product);
  }

  public Long updateProduct(Product product) {
    var productStatus = product.getProductStatus();
    if (productStatus != null && productStatus.equalsIgnoreCase(ProductStatus.PUBLISHED.name())) {
      throw new InvalidOperationException("Product status cannot be changed");
    }
    product.setProductStatus(ProductStatus.DRAFT.name());
    return productCatalogRepository.save(product);
  }

  public void deleteProduct(Long productId) {
    productCatalogRepository.delete(productId);
  }

  public List<Product> getAll(QueryParameter queryParameter) {
    return productCatalogRepository.getAll(queryParameter);
  }

  public Product get(Long productId) {
    return productCatalogRepository.get(productId);
  }

  public void publish(Long productId) {
    var product = productCatalogRepository.get(productId);
    if (!product.getProductStatus().equalsIgnoreCase(ProductStatus.DRAFT.name())) {
      throw new InvalidOperationException("Only DRAFT product can be published");
    }
    product.setProductStatus(ProductStatus.PUBLISHED.name());
    productCatalogRepository.save(product);
  }
}
