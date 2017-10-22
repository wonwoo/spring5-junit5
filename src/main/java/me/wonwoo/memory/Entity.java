package me.wonwoo.memory;

import java.util.UUID;

public interface Entity<T extends UUID> {

  T getId();

  void setId(T id);
}
