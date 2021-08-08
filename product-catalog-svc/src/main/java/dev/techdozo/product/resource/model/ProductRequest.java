package dev.techdozo.product.resource.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class ProductRequest {
  private Long productId;

  @NotNull(message = "Product name is required.")
  @NotBlank(message = "Product name cannot be blank.")
  private String productName;

  private String description;

  @NotNull(message = "Price is required.")
  @NotBlank(message = "Price cannot be blank.")
  private String price;

  @NotNull(message = "Model is required.")
  @NotBlank(message = "Model cannot be blank.")
  private String model;

  private String brand;
}
