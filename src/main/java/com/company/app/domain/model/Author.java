package com.company.app.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Author {
  private final String firstName;
  private final String lastName;

  public Author(String fullName) {
    if (fullName == null) {
      throw new IllegalArgumentException("Author's full name is required.");
    }
    if (!fullName.contains(" ")) {
      throw new IllegalArgumentException("Author's full name is required.");
    }
    this.firstName = fullName.substring(0, fullName.indexOf(' '));
    this.lastName = fullName.substring(fullName.indexOf(' '));
  }

  public String firstName() {
    return firstName;
  }

  public String lastName() {
    return lastName;
  }

  public String fullName() {
    return this.firstName + " " + this.lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(firstName, author.firstName) &&
      Objects.equals(lastName, author.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
      .add("firstName='" + firstName + "'")
      .add("lastName='" + lastName + "'")
      .toString();
  }
}
