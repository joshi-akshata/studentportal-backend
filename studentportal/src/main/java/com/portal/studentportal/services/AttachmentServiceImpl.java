package com.portal.studentportal.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.portal.studentportal.entities.Attachment;
import com.portal.studentportal.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	@Autowired
	AttachmentRepository attachmentRepository;
	
	public Attachment addAttachment(MultipartFile file) throws IOException
	{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Attachment attachment = new Attachment(fileName, file.getContentType(),file.getBytes());
	    return attachmentRepository.save(attachment);
	}

	public Attachment getAttachment(Integer id)
	{
		return attachmentRepository.findById(id).get();
	}
}
