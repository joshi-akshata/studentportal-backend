package com.portal.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.studentportal.entities.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

	@Query(value = "Select * from attachment a where a.activity_id=:activityId", nativeQuery = true)
	public Attachment findByActivityId(int activityId);

	@Query(value = "select * from attachment a where a.name=:name and a.id=:id", nativeQuery = true)
	public Attachment findByNameAndId(String name, Integer id);
}
