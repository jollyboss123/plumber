package com.jolly.order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * An entity mapping that represents a line item on a {@link PurchaseOrder} entity.
 */
@Setter
@Getter
@Entity
public class OrderLine {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_line_ids")
  @SequenceGenerator(name = "order_line_ids", sequenceName = "seq_order_line")
  private Long id;

  private String item;

  private int quantity;

  private BigDecimal totalPrice;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private PurchaseOrder purchaseOrder;

  @Enumerated(EnumType.STRING)
  private OrderLineStatus status;

  protected OrderLine() {
  }

  public OrderLine(String item, int quantity, BigDecimal totalPrice) {
    this.item = item;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    this.status = OrderLineStatus.ENTERED;
  }

}

