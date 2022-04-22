package org.a.demo.entities.summary;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "title")
public class Title extends Summary {

	private String text;

	public Title() {
	}

	public Title(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
