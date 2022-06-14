package com.portal.studentportal.implementation;

import java.util.List;

import com.portal.studentportal.entities.Notification;
import com.portal.studentportal.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.studentportal.entities.Activity;
import com.portal.studentportal.repository.ActivityRepository;
import com.portal.studentportal.services.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public List<Activity> getAllActivity() {
		return (List<Activity>) activityRepository.findAll();

	}

	@Override
	public Activity getActivityById(int activityId) {
		return activityRepository.findById(activityId).get();
	}

	@Override
	public Activity addActivity(Activity activity) {
		Activity addActivity = activityRepository.save(activity);
		Notification notification = new Notification();

		notification.setStatus(1);
		notification.setMessage(
				activity.getName() != null ? "new activity added:" + activity.getName() : "new activity added");
		notificationRepository.save(notification);

		return addActivity;
	}

	@Override
	public Activity updateActivity(Activity activity, int activityId) {
		Activity a = activityRepository.findById(activityId).get();

		a.setNotice(activity.getNotice());
		a.setExamdetails(activity.getExamdetails());
		a.setName(activity.getName());
		a.setDate(activity.getDate());
		Activity updateActivity = activityRepository.save(a);

		Notification notification = new Notification();

		notification.setStatus(1);
		notification
				.setMessage(activity.getName() != null ? "activity updated:" + activity.getName() : "activity updated");
		notificationRepository.save(notification);
		return updateActivity;
	}

	@Override
	public void deleteActivity(int activityId) {
		activityRepository.deleteById(activityId);

	}

}
