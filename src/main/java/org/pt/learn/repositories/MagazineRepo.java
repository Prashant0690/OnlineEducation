package org.pt.learn.repositories;

import org.pt.learn.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepo extends JpaRepository<Magazine, Long> {

}
