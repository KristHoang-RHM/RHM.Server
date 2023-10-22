package com.rhm.server.data.models;

import com.rhm.server.models.Audit;
import com.rhm.server.models.Role;
import com.rhm.server.models.Tracking;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Users")
public class User implements Serializable, Tracking, Audit {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  private String UserName;

  private String FullName;
  private String Email;
  private String PhoneNumber;

  private String HashedPassword;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role Role;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getFullName() {
    return FullName;
  }

  public void setFullName(String fullName) {
    FullName = fullName;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getPhoneNumber() {
    return PhoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    PhoneNumber = phoneNumber;
  }

  public Role getRole() {
    return Role;
  }

  public void setRole(Role role) {
    Role = role;
  }
}
