package com.portal.studentportal.controller;

import com.portal.studentportal.entities.Notification;
import com.portal.studentportal.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public List<Notification> getAllNotification() {
        return notificationService.getAllNotification();
    }

    @GetMapping("/notification/count")
    public Integer getNotificationCount() {
        return notificationService.getNotificationCount();
    }

    @GetMapping("/notification/{id}")
    public Notification getNotificationById(@PathVariable Integer id) {
        return notificationService.getNotificationById(id);
    }

    @PutMapping("/notification/{id}")
    public void updateNotification(@PathVariable Integer id, @RequestBody Notification notification) {
        notificationService.updateNotification(id, notification);
    }

}
