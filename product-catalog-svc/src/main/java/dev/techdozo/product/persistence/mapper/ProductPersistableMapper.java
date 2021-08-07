package dev.techdozo.product.persistence.mapper;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.persistence.repository.model.ProductPersistable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductPersistableMapper {

  public static final ProductPersistableMapper MAPPER =
      Mappers.getMapper(ProductPersistableMapper.class);

  @Mapping(source = "productId", target = "id")
  public abstract ProductPersistable map(Product product);

  @Mapping(source = "id", target = "productId")
  public abstract Product map(ProductPersistable productPersistable);
}
