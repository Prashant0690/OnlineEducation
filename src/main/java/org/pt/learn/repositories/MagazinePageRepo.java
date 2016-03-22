package org.pt.learn.repositories;

import java.util.List;

import org.pt.learn.entity.Magazine;
import org.pt.learn.entity.MagazinePage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazinePageRepo extends JpaRepository<MagazinePage, Long> {
	
	List<MagazinePage> findByMagazine(Magazine magazine);

}
