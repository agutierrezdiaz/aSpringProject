package org.a.demo.entities.summary;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "quote")
public class Quote extends Summary {

	private String text;
	private String author;

	public Quote() {
	}

	public Quote(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
