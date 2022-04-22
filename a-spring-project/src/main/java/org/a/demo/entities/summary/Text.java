package org.a.demo.entities.summary;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "text")
public class Text extends Summary {

	private String paragraph;

	public Text() {
	}

	public Text(String paragraph) {
		this.paragraph = paragraph;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

}
