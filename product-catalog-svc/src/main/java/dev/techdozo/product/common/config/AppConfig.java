package dev.techdozo.product.common.config;

import dev.techdozo.product.application.command.ProductCatalogCommand;
import dev.techdozo.product.application.command.impl.ProductCatalogCommandImpl;
import dev.techdozo.product.application.domain.repository.ProductCatalogRepository;
import dev.techdozo.product.application.factory.ProductCatalogFactory;
import dev.techdozo.product.application.factory.impl.ProductCatalogFactoryImpl;
import dev.techdozo.product.application.query.ProductCatalogQuery;
import dev.techdozo.product.application.query.impl.ProductCatalogQueryImpl;
import dev.techdozo.product.persistence.repository.ProductCatalogRepositoryImpl;
import dev.techdozo.product.persistence.repository.jpa.ProductCatalogJpaRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class AppConfig {

  @Autowired private ProductCatalogJpaRepository productCatalogJpaRepository;

  @Bean
  public ProductCatalogFactory productCatalogFactory() {
    return new ProductCatalogFactoryImpl(productCatalogCommand(), productCatalogQuery());
  }

  private ProductCatalogQuery productCatalogQuery() {
    return new ProductCatalogQueryImpl(productCatalogRepository());
  }

  @Bean
  public ProductCatalogCommand productCatalogCommand() {
    return new ProductCatalogCommandImpl(productCatalogRepository());
  }

  private ProductCatalogRepository productCatalogRepository() {
    return new ProductCatalogRepositoryImpl(productCatalogJpaRepository);
  }
}
