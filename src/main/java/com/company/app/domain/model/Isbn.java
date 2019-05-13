package com.company.app.domain.model;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Isbn {
  private static final Pattern ISBN10_ISBN13_PATTERN = Pattern.compile("^(\\d{9}|\\d{12})[\\d|X]$");

  private final String value;

  public Isbn(String isbn) {
    if (!ISBN10_ISBN13_PATTERN.matcher(isbn).matches()) {
      throw new InvalidFormat(String.format("The ISBN format for \"%s\" is not valid.", isbn));
    }
    this.value = isbn;
  }

  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Isbn isbn = (Isbn) o;
    return Objects.equals(value, isbn.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Isbn.class.getSimpleName() + "[", "]")
      .add("value='" + value + "'")
      .toString();
  }

  public static class InvalidFormat extends RuntimeException {
    InvalidFormat(String message) {
      super(message);
    }
  }
}
