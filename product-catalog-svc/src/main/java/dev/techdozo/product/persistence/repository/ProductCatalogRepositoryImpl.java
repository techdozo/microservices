package dev.techdozo.product.persistence.repository;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.application.domain.repository.ProductCatalogRepository;
import dev.techdozo.product.application.query.model.QueryParameter;
import dev.techdozo.product.common.error.ResourceNotFoundException;
import dev.techdozo.product.persistence.mapper.ProductPersistableMapper;
import dev.techdozo.product.persistence.repository.jpa.ProductCatalogJpaRepository;
import dev.techdozo.product.persistence.repository.model.ProductPersistable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductCatalogRepositoryImpl implements ProductCatalogRepository {

  private final ProductCatalogJpaRepository productCatalogJpaRepository;

  public ProductCatalogRepositoryImpl(ProductCatalogJpaRepository productCatalogJpaRepository) {
    this.productCatalogJpaRepository = productCatalogJpaRepository;
  }

  @Override
  public Long save(Product product) {
    var entity = ProductPersistableMapper.MAPPER.map(product);
    entity = productCatalogJpaRepository.save(entity);
    return entity.getId();
  }

  @Override
  public Product get(Long productId) {
    Optional<ProductPersistable> productPersistable =
        productCatalogJpaRepository.findById(productId);
    return productPersistable
        .map(ProductPersistableMapper.MAPPER::map)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  }

  @Override
  public List<Product> getAll(QueryParameter queryParameter) {
    var productPersistables = productCatalogJpaRepository.findAll(queryParameter.getStatus());
    return productPersistables.stream()
        .map(ProductPersistableMapper.MAPPER::map)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Long productId) {
    productCatalogJpaRepository.deleteById(productId);
  }
}
