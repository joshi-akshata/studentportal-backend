package com.portal.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.studentportal.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
