package me.wonwoo.memory.ids;

import java.util.UUID;

public class JdkIdGenerator implements IdGenerator {

  @Override
  public <T extends UUID> T getId() {
    return (T) UUID.randomUUID();
  }
}
