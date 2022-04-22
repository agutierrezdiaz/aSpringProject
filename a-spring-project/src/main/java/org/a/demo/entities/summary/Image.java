package org.a.demo.entities.summary;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "image")
public class Image extends Summary {

	private String image;

	public Image() {
	}

	public Image(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
