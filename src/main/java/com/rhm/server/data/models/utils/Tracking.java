package com.rhm.server.data.models.utils;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public interface Tracking {

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "status")
  Status status = Status.Available;
}
