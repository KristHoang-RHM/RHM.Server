package com.rhm.server.data.models;

import com.rhm.server.data.models.utils.Role;
import com.rhm.server.data.models.utils.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Users")
public class User implements Serializable {
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  private Status status = Status.Available;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private String UserName;
  private String FullName;
  private String Email;
  private String PhoneNumber;
  private String HashedPassword;
  private Timestamp CreatedAt = null;
  private Timestamp UpdatedAt = null;
  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role Role;

  @OneToOne
  @NotFound(action = NotFoundAction.IGNORE)
  private Customer Customer;

  @OneToMany(mappedBy = "Owner", fetch = FetchType.LAZY)
  private Collection<House> OwnedHouses;

  @OneToOne(mappedBy = "Manager", fetch = FetchType.LAZY)
  @NotFound(action = NotFoundAction.IGNORE)
  private House ManageHouse;
}
