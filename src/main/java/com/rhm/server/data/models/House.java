package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Houses")
public class House implements Serializable {
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  @Column(name = "id_owner", insertable = false, updatable = false)
  private Integer IdOwner;

  @Column(name = "id_manager", insertable = false, updatable = false)
  private Integer IdManager;
  private String Address;
  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;

  @ManyToOne
  @JoinColumn(name = "id_owner", referencedColumnName = "id")
  private User Owner;

  @OneToOne
  @JoinColumn(name = "id_manager", referencedColumnName = "id")
  private User Manager;

  @OneToMany(mappedBy = "House", fetch = FetchType.LAZY)
  private Collection<AdditionalFee> AdditionalFees;

  @OneToMany(mappedBy = "House", fetch = FetchType.LAZY)
  private Collection<Room> Rooms;

}
