package org.pt.learn.repositories;

import java.util.List;

import org.pt.learn.entity.MagazinePage;
import org.pt.learn.entity.MagazinePageDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazinePageDevelopmentRepo extends JpaRepository<MagazinePageDevelopment, Long> {
	
	List<MagazinePageDevelopment> findByMagazinePage(MagazinePage magazinePage);
	
	

}
