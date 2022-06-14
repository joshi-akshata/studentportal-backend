package com.portal.studentportal.controller;

import java.util.List;

import com.portal.studentportal.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.portal.studentportal.entities.Attachment;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin("*")
public class AttachmentController {

  @Autowired
  private AttachmentService attachmentService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";
    try {

      attachmentService.addAttachment(file);
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }
  }

  @GetMapping("/files/{name}/{id}")
  public ResponseEntity<Resource> getFile(@PathVariable String name, @PathVariable Integer id) {
    Attachment attachment = attachmentService.getAttachment(name, id);
    final HttpHeaders responseHeader = new HttpHeaders();
    responseHeader.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getName() + "\"");
    responseHeader.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
    return ResponseEntity.ok()
        .headers(responseHeader)
        .contentType(MediaType.parseMediaType(attachment.getType()))
        .body(new ByteArrayResource(attachment.getData()));
  }

  @GetMapping("/files")
  public List<Attachment> getAllFiles() {
    return attachmentService.getAllAttachments();

  }

  @DeleteMapping("/files/{attId}")
  public void deleteAttachment(@PathVariable(name = "attId") Integer attId) {
    attachmentService.deleteAttachment(attId);
  }

}
