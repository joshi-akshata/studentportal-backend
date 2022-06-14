package com.portal.studentportal.services;

import com.portal.studentportal.entities.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getAllNotification();

    Integer getNotificationCount();

    Notification getNotificationById(Integer id);

    void updateNotification(Integer id, Notification notification);
}
