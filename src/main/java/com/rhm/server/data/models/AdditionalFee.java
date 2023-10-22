package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.FeeType;
import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Additional_Fees")
public class AdditionalFee implements Serializable {

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @Id
  @GeneratedValue
  private Integer Id;
  @Column(name = "id_house", insertable = false, updatable = false)
  private Integer IdHouse;
  private String Name;
  private BigDecimal Price;
  @Enumerated(EnumType.STRING)
  private FeeType FeeType;
  private String Description;
  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;

  @ManyToOne
  @JoinColumn(name = "id_house", referencedColumnName = "id")
  private House House;

  @OneToMany(mappedBy = "AdditionalFee")
  private Collection<ReceiptDetail> ReceiptDetailList;

}
