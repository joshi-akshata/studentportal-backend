package com.portal.studentportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.studentportal.entities.Activity;
import com.portal.studentportal.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	 private ActivityRepository activityRepository;
	
	
	@Override
   public List<Activity> getAllActivity()
	{
		return (List<Activity>) activityRepository.findAll();
		
	}
	
	
	

	@Override
	 public Activity getActivityById(int activityId) 
	   {
	      return activityRepository.findById(activityId).get();
	   }
		
	
	
	
	@Override
	public Activity addActivity(Activity activity)
	{
		return  activityRepository.save(activity);
	}
	

	
	
	@Override
	public Activity updateActivity(Activity activity,int activityId)
	{
		Activity a= activityRepository.findById(activityId).get();

		a.setNotice(activity.getNotice());
		a.setExamdetails(activity.getExamdetails());
		a.setName(activity.getName());
		a.setDate(activity.getDate());
				
	    return activityRepository.save(a);
	}
		
	

	

	    @Override
	    public void deleteActivity(int activityId) 
	    {
	    	activityRepository.deleteById(activityId);
		 
	    }
	 
	 

   

}
