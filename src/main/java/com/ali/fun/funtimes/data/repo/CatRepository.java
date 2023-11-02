package com.ali.fun.funtimes.data.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends ReactiveCrudRepository<Cat, Long> {
}
