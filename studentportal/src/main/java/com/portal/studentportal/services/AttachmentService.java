package com.portal.studentportal.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.portal.studentportal.entities.Attachment;

public interface AttachmentService {

	Attachment addAttachment(MultipartFile file) throws IOException;

	Attachment getAttachment(String name, Integer id);

	List<Attachment> getAllAttachments();

	void deleteAttachment(Integer id);
}
