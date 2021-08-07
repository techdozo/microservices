package dev.techdozo.product.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product {
  private Long productId;
  private String productStatus;
  private String productName;
  private String description;
  private String price;
  private String model;
  private String brand;
}
