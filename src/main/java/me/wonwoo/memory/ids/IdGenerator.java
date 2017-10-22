package me.wonwoo.memory.ids;

import java.util.UUID;

public interface IdGenerator {

  <T extends UUID> T getId();
}
