package com.rhm.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public interface Tracking {

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  Status status = Status.Available;
}
