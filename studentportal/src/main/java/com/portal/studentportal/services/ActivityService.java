package com.portal.studentportal.services;

import java.util.List;

import com.portal.studentportal.entities.Activity;

public interface ActivityService {
	
    List<Activity> getAllActivity();
	
    Activity getActivityById(int activityId);
	
    Activity addActivity(Activity activity);
	
    Activity updateActivity(Activity activity,int activityId);
    
    void deleteActivity(int activityId);

}
