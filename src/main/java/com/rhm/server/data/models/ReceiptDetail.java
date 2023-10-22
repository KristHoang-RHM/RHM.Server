package com.rhm.server.data.models;

import com.rhm.server.data.models.keys.ReceiptDetailId;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Receipt_Detail")
public class ReceiptDetail implements Serializable {
  @EmbeddedId
  private ReceiptDetailId ReceiptDetailId;

  private Double Usage;
  private String ProofImage;

  @ManyToOne
  @JoinColumn(name = "id_receipt", referencedColumnName = "id", insertable = false, updatable = false)
  private Receipt Receipt;

  @ManyToOne
  @JoinColumn(name = "id_fee", referencedColumnName = "id", insertable = false, updatable = false)
  private AdditionalFee AdditionalFee;
}
