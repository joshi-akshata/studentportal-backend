package com.portal.studentportal.repository;

import com.portal.studentportal.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "SELECT COUNT(n.id) From Notification n " +
            "WHERE n.status=1 ", nativeQuery = true)
    Integer getCount();

    @Query(value = "SELECT * FROM Notification ORDER BY id DESC;", nativeQuery = true)
    List<Notification> getAllNotifications();
}
