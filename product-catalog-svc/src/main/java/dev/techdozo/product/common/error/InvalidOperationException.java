package dev.techdozo.product.common.error;

public class InvalidOperationException extends RuntimeException {
  public InvalidOperationException(String message) {
    super(message);
  }
}
