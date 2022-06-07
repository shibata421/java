package com.acme.blog.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.blog.domain.comment.CommentDto;
import com.acme.blog.domain.comment.CommentService;
import com.acme.blog.domain.comment.NewCommentDto;
import com.acme.blog.domain.post.PostDto;
import com.acme.blog.domain.post.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	private final PostService postService;
	private final CommentService commentService;

	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping("/{id}")
	public Optional<PostDto> getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}

	@GetMapping("/{id}/comments")
	public List<CommentDto> getComments(@PathVariable Long id) {
		try {
			List<CommentDto> comments = commentService.getCommentsForPost(id);
			return comments;
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException();
		}
	}

	@PostMapping("/{id}/comment")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addComment(@PathVariable Long id, @RequestBody NewCommentDto newCommentDto) {
		newCommentDto.setPostId(id);
		try {
			commentService.addComment(newCommentDto);
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException();
		}
	}

	@SuppressWarnings("serial")
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	class ResourceNotFoundException extends RuntimeException {
	}
}
