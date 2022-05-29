package com.portal.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.studentportal.entities.Activity;
import com.portal.studentportal.services.ActivityService;

@RestController
@CrossOrigin("*")
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @GetMapping("/activity")
  public List<Activity> getAllActivity() {
    return activityService.getAllActivity();
  }

  @GetMapping("/activity/{activityId}")
  public Activity getActivityById(@PathVariable(name = "activityId") int activityId) {
    return activityService.getActivityById(activityId);
  }

  @PostMapping("/activity")
  public Activity addActivity(@RequestBody Activity activity) {
    return activityService.addActivity(activity);
  }

  @PutMapping("/activity/{activityId}")
  public Activity updateActivity(@PathVariable("activityId") int activityId, @RequestBody Activity activity) {
    return activityService.updateActivity(activity, activityId);
  }

  @DeleteMapping("/activity/{activityId}")
  public void deleteActivity(@PathVariable(name = "activityId") int activityId) {
    activityService.deleteActivity(activityId);
  }

}
