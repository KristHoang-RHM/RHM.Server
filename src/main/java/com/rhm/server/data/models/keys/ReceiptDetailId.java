package com.rhm.server.data.models.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class ReceiptDetailId implements Serializable {
  @Column(nullable = false, name = "id_receipt", insertable = false, updatable = false)
  private Integer IdReceipt;
  @Column(nullable = false, name = "id_fee", insertable = false, updatable = false)
  private Integer IdFee;

  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;
}
