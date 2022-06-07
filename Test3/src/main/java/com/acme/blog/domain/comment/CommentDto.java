package com.acme.blog.domain.comment;

import java.time.LocalDate;

import lombok.Value;

@Value
public class CommentDto {

	private final Long id;
	private final String comment;
	private final String author;
	private final LocalDate creationDate;
	
	public CommentDto(Long id, String comment, String author, LocalDate creationDate) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

}
