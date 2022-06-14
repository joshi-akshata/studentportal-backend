package com.portal.studentportal.services;

import java.util.List;

import com.portal.studentportal.entities.Post;

public interface PostService {

	List<Post> getAllPost();

	Post getPostById(Integer postId);

	Post addPost(Post post);

	Post updatePost(Post post, Integer postId);

	void deletePost(Integer postId);

}
