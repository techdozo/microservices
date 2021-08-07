package dev.techdozo.product.persistence.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name = "product_catalog")
public class ProductPersistable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String productStatus;
  private String productName;
  private String description;
  private String price;
  private String model;
  private String brand;
}
