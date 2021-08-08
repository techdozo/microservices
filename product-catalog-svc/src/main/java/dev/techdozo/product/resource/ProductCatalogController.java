package dev.techdozo.product.resource;

import dev.techdozo.product.application.factory.ProductCatalogFactory;
import dev.techdozo.product.application.query.model.QueryParameter;
import dev.techdozo.product.resource.mapper.ProductRequestMapper;
import dev.techdozo.product.resource.model.GetProductResponse;
import dev.techdozo.product.resource.model.ProductRequest;
import dev.techdozo.product.resource.model.ProductResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ProductCatalogController {

  @Autowired private ProductCatalogFactory productCatalogFactory;

  @PostMapping("/products")
  public ResponseEntity<ProductResponse> createProduct(
      @RequestHeader("sellerId") String sellerId,
      @Valid @RequestBody ProductRequest productRequest) {

    log.info("Creating product, name {}", productRequest.getProductName());

    var product = ProductRequestMapper.MAPPER.map(productRequest);
    var productCatalogCommand = productCatalogFactory.getProductCatalogCommand();

    var productId = productCatalogCommand.addProduct(product);

    var productResponse = new ProductResponse(productId);
    return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
  }

  @PutMapping("/products")
  public ResponseEntity<ProductResponse> updateProduct(
      @RequestHeader("sellerId") String sellerId,
      @Valid @RequestBody ProductRequest productRequest) {

    log.info("Updating product, name {}", productRequest.getProductName());

    var product = ProductRequestMapper.MAPPER.map(productRequest);
    var productCatalogCommand = productCatalogFactory.getProductCatalogCommand();

    var productId = productCatalogCommand.updateProduct(product);

    var productResponse = new ProductResponse(productId);
    if (productRequest.getProductId() == null) {
      return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(productResponse, HttpStatus.OK);
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<GetProductResponse> getProductById(
      @RequestHeader("sellerId") String sellerId, @PathVariable @NonNull Long productId) {

    log.info("Getting product, id {}", productId);

    var productCatalogQuery = productCatalogFactory.getProductQuery();

    var product = productCatalogQuery.getProduct(productId);

    var productResponse = ProductRequestMapper.MAPPER.map(product);

    return new ResponseEntity<>(productResponse, HttpStatus.OK);
  }

  @GetMapping("/products")
  public ResponseEntity<List<GetProductResponse>> listProducts(
      @RequestHeader("sellerId") String sellerId, @RequestParam String status) {

    log.info("Getting all products");

    var productCatalogQuery = productCatalogFactory.getProductQuery();

    var queryParameter = new QueryParameter();
    queryParameter.setStatus(status);

    var products = productCatalogQuery.getProducts(queryParameter);

    var productResponse =
        products.stream().map(ProductRequestMapper.MAPPER::map).collect(Collectors.toList());

    return new ResponseEntity<>(productResponse, HttpStatus.OK);
  }

  @DeleteMapping("/products/{productId}")
  public ResponseEntity<Void> deleteProduct(
      @RequestHeader("sellerId") String sellerId, @PathVariable @NonNull Long productId) {

    log.info("Deleting product, id {}", productId);

    var productCatalogCommand = productCatalogFactory.getProductCatalogCommand();

    productCatalogCommand.deleteProduct(productId);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/products/{productId}/publish")
  public ResponseEntity<Void> publishProduct(
      @RequestHeader("sellerId") String sellerId, @PathVariable @NonNull Long productId) {

    log.info("Publishing product, id {}", productId);

    var productCatalogCommand = productCatalogFactory.getProductCatalogCommand();

    productCatalogCommand.publish(productId);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
