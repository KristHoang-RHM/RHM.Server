package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.RoomStatus;
import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Rooms")
public class Room implements Serializable {

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @jakarta.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  @Column(name = "id_house", insertable = false, updatable = false)
  private Integer IdHouse;
  private Integer MaxCapacity;
  private BigDecimal RentFee;
  private BigDecimal Deposit;
  @Enumerated(EnumType.STRING)
  private RoomStatus RoomStatus;
  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;

  @OneToMany(mappedBy = "Room")
  private Collection<Customer> Customers;

  @ManyToOne
  @JoinColumn(name = "id_house", referencedColumnName = "id")
  private House House;

  @OneToMany(mappedBy = "Room", fetch = FetchType.LAZY)
  private Collection<Receipt> Receipts;
}
