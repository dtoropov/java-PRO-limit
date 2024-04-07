package ru.vtb.toropov.limit.dtos;

import java.math.BigDecimal;

/**
 * PaymentDto.
 *
 * @author DToropov
 */
public class PaymentDto {
  private BigDecimal amount;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PaymentDto(BigDecimal amount) {
    this.amount = amount;
  }

  public PaymentDto() {
  }
}
