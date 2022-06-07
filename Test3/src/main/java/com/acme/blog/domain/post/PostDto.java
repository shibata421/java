package com.acme.blog.domain.post;

import java.time.LocalDate;

import lombok.Value;

@Value
public class PostDto {
	private final String title;
	private final String content;
	private final LocalDate creationDate;

	public PostDto(String title, String content, LocalDate creationDate) {
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

}
