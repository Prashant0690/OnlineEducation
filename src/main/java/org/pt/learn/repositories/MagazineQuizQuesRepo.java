package org.pt.learn.repositories;

import java.util.List;

import org.pt.learn.entity.MagazineQuizQues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineQuizQuesRepo extends JpaRepository<MagazineQuizQues, Long> {
	
	List<MagazineQuizQues> findByCourseTypeId(String courseTypeId);
	
	List<MagazineQuizQues> findByCourseTypeIdOrderByQuesOrderNo(String courseTypeId);
}
