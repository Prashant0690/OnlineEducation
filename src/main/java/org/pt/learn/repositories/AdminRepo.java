package org.pt.learn.repositories;

import org.pt.learn.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
