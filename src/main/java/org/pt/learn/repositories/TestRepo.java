package org.pt.learn.repositories;

import org.pt.learn.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<TestEntity, Long> {

}
