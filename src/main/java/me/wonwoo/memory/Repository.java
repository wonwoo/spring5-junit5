package me.wonwoo.memory;

import java.util.List;
import java.util.UUID;

public interface Repository<T extends Entity<ID>, ID extends UUID> {

  List<T> findAll();

  T findOne(ID id);

  <S extends T> S save(S entity);

  <S extends T> List<S> save(Iterable<S> entities);

  void delete(ID id);

  void delete(T entity);

  void deleteAll(Iterable<? extends T> entities);
}
