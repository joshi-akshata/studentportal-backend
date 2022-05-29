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

import com.portal.studentportal.entities.Post;
import com.portal.studentportal.services.PostService;

@RestController
@CrossOrigin("*")
public class PostController {

	 @Autowired
	  private PostService postService;

	  @GetMapping("/post")
	  public List<Post> getAllPost() {
	    return postService.getAllPost();
	  }

	  @GetMapping("/post/{postId}")
	  public Post getPostById(@PathVariable Integer postId) {
	    return postService.getPostById(postId);
	  }

	  @PostMapping("/post")
	  public Post addPost(@RequestBody Post post) {
	    return postService.addPost(post);
	  }
	  
	  @PutMapping("/post/{postId}")
	  public Post updatePost(@PathVariable Integer postId, @RequestBody Post post) {
	    return postService.updatePost(post, postId);
	  }

	  @DeleteMapping("/post/{postId}")
	  public void deletePost(@PathVariable Integer postId) {
		  postService.deletePost(postId);
	  }
}
