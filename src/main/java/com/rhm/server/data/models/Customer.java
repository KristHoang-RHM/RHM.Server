package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  @Column(name = "id_user", insertable = false, updatable = false)
  private Integer IdUser;

  @Column(name = "id_room", insertable = false, updatable = false)
  private Integer IdRoom;
  private String IdNumber;
  private String IdImageFront;
  private String IdImageBack;
  private String IDRegisterPlace;
  private String IdRegisterDate;
  private String ResidentAddress;

  @OneToOne
  @NotFound(action = NotFoundAction.IGNORE)
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User User;

  @ManyToOne
  @JoinColumn(name = "id_room", referencedColumnName = "id")
  private Room Room;
}
