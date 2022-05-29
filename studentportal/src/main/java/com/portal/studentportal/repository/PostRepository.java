package com.portal.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.studentportal.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
