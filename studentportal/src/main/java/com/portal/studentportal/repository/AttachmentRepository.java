package com.portal.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.studentportal.entities.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
