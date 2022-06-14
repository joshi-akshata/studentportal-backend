package com.portal.studentportal.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.studentportal.entities.Post;
import com.portal.studentportal.repository.PostRepository;
import com.portal.studentportal.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();

	}

	@Override
	public Post getPostById(Integer postId) {
		return postRepository.findById(postId).get();
	}

	@Override
	public Post addPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Post post, Integer postId) {
		Post p = postRepository.findById(postId).get();

		p.setContent(post.getContent());

		return postRepository.save(p);
	}

	@Override
	public void deletePost(Integer postId) {
		postRepository.deleteById(postId);

	}
}
