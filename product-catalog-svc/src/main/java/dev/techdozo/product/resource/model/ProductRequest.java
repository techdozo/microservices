package dev.techdozo.product.resource.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductRequest {
  private Long productId;
  private String productName;
  private String description;
  private String price;
  private String model;
  private String brand;
}
