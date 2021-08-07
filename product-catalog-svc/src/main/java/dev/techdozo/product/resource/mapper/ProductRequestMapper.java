package dev.techdozo.product.resource.mapper;

import dev.techdozo.product.application.domain.model.Product;
import dev.techdozo.product.resource.model.ProductRequest;
import dev.techdozo.product.resource.model.GetProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductRequestMapper {

  public static final ProductRequestMapper MAPPER = Mappers.getMapper(ProductRequestMapper.class);

  public abstract Product map(ProductRequest request);

  public abstract GetProductResponse map(Product product);
}
