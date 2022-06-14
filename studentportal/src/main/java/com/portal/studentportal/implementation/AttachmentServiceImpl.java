package com.portal.studentportal.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.portal.studentportal.entities.Attachment;
import com.portal.studentportal.repository.AttachmentRepository;
import com.portal.studentportal.services.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	AttachmentRepository attachmentRepository;

	@Override
	public Attachment addAttachment(MultipartFile file) throws IOException {
		String fileNameWithExtension = StringUtils.cleanPath(file.getOriginalFilename());
		String fileExtension = getFilenameExtension(fileNameWithExtension);
		String fileName = fileNameWithExtension.replace("." + fileExtension, "");
		Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
		return attachmentRepository.save(attachment);
	}

	public static String getFilenameExtension(String filename) {
		String extension = "NoExtension";
		int i = filename.lastIndexOf('.');
		if (i > 0) {
			extension = filename.substring(i + 1);
		}
		return extension;
	}

	@Override
	public Attachment getAttachment(String name, Integer id) {
		return attachmentRepository.findByNameAndId(name, id);
	}

	@Override
	public List<Attachment> getAllAttachments() {

		List<Attachment> attachments = attachmentRepository.findAll();

		return attachments;
	}

	@Override
	public void deleteAttachment(Integer attId) {
		attachmentRepository.deleteById(attId);
	}
}
