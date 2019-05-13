package com.company.app.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Title {
  private final String value;

  public Title(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Title title = (Title) o;
    return Objects.equals(value, title.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Title.class.getSimpleName() + "[", "]")
      .add("value='" + value + "'")
      .toString();
  }
}
