package org.pt.learn.repositories;

import org.pt.learn.entity.GResume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GResumeRepo extends JpaRepository<GResume, Long> {
	
	GResume findByResumeUserId(String resumeUserId);

}
