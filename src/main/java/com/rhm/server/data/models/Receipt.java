package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.PaymentMethod;
import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Receipts")
public class Receipt implements Serializable {
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @jakarta.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  @Column(name = "id_room", insertable = false, updatable = false)
  private Integer IdRoom;
  private BigDecimal Total;
  private Date PayDate;
  private String ProofImage;
  @Enumerated(EnumType.STRING)
  private PaymentMethod PaymentMethod;
  private String Description;
  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;

  @ManyToOne
  @JoinColumn(name = "id_room", referencedColumnName = "id")
  private Room Room;

  @OneToMany(mappedBy = "Receipt", fetch = FetchType.LAZY)
  private Collection<ReceiptDetail> Detail;
}
