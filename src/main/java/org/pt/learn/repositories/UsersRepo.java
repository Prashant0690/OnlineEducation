package org.pt.learn.repositories;

import org.pt.learn.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {

	Users findByUserName(String userName);
}
