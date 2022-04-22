package org.a.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.a.demo.entities.summary.Image;
import org.a.demo.entities.summary.Quote;
import org.a.demo.entities.summary.Summary;
import org.a.demo.entities.summary.Text;
import org.a.demo.entities.summary.Title;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity class for the content type Article
 * 
 * @author Adrian Gutierrez
 *
 */
@Document(collection = "articles")
public class Article {

	@Id
	private String id;
	private String title;
	private String subtitle;
	private Date publishDate;
	private String author;
	private String image;
	private Collection<Summary> summary;

	public Article() {
	}

	public Article(String title, Date publishDate, String author) {
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Collection<Summary> getSummary() {
		return summary;
	}

	public void setSummary(Collection<Summary> summary) {
		this.summary = summary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", summary=" + summary + ", publishDate=" + publishDate
				+ ", author=" + author + "]";
	}

	public static class Builder {

		private Article article;
		private Collection<Summary> summary;

		public Builder() {
			article = new Article();
			summary = new ArrayList<>();
		}

		public Builder setInfo(String title, Date publishDate, String author) {
			article.setTitle(title);
			article.setPublishDate(publishDate);
			article.setAuthor(author);
			return this;
		}

		public Builder setSubtitle(String subtitle) {
			article.setSubtitle(subtitle);
			return this;
		}

		public Builder setImage(String image) {
			article.setImage(image);
			return this;
		}

		public Builder addParagraph(String text) {
			summary.add(new Text(text));
			return this;
		}

		public Builder addBodyImage(String image) {
			summary.add(new Image(image));
			return this;
		}

		public Builder addBodyTitle(String title) {
			summary.add(new Title(title));
			return this;
		}

		public Builder addQuote(String quote, String author) {
			summary.add(new Quote(quote, author));
			return this;
		}

		public Article build() {
			article.setSummary(summary);
			return article;
		}

	}

}
