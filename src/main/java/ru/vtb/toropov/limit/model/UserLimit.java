package ru.vtb.toropov.limit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * User.
 *
 * @author DToropov
 */
@Entity
@Table(name = "user_limit", schema = "java_pro")
public class UserLimit {
  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;

  @Column(name = "value_limit")
  private BigDecimal valueLimit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getValueLimit() {
    return valueLimit;
  }

  public void setValueLimit(BigDecimal valueLimit) {
    this.valueLimit = valueLimit;
  }

  public UserLimit(Long id, String name, BigDecimal valueLimit) {
    this.id = id;
    this.name = name;
    this.valueLimit = valueLimit;
  }

  public UserLimit() {
  }
}
