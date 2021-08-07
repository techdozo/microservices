package dev.techdozo.product.resource.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GetProductResponse {
  private Long productId;
  private String productStatus;
  private String productName;
  private String description;
  private String price;
  private String model;
  private String brand;
}
