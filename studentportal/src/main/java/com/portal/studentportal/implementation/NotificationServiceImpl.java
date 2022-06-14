package com.portal.studentportal.implementation;

import com.portal.studentportal.entities.Notification;
import com.portal.studentportal.repository.NotificationRepository;
import com.portal.studentportal.services.NotificationService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotification() {
        return notificationRepository.getAllNotifications();
    }

    @Override
    public Integer getNotificationCount() {
        return notificationRepository.getCount();
    }

    @Override
    public Notification getNotificationById(Integer id) {
        return notificationRepository.findById(id).get();
    }

    @Override
    public void updateNotification(Integer id, Notification notification) {
        Notification notifications = notificationRepository.findById(id).get();

        notifications.setStatus(0);
        notificationRepository.save(notifications);
    }
}
