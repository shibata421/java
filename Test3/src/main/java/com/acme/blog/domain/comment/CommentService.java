package com.acme.blog.domain.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.blog.domain.post.Post;
import com.acme.blog.domain.post.PostRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 * @throws IllegalArgumentException if there is no blog post for passed postId
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		List<Comment> comments = commentRepository.findAllByPostId(postId);
		if(comments.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		List<CommentDto> commentsDto = new ArrayList<>();
		comments.forEach(comment -> {
			commentsDto.add(new CommentDto(postId, comment.getContent(), comment.getAuthor(), comment.getCreationDate()));
		});
		
		return commentsDto;
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of created comment
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		Comment comment = new Comment(newCommentDto);
		Optional<Post> post = postRepository.findById(newCommentDto.getPostId());

		if(!post.isPresent()) {
			throw new IllegalArgumentException();
		}
		
		comment.setPost(post.get());
		commentRepository.save(comment);
		return comment.getId();
	}
}
