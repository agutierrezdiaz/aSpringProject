package org.a.demo.services;

import java.util.List;
import java.util.Optional;

import org.a.demo.entities.Article;
import org.a.demo.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class for content type Article
 * @author Adrian Gutierrez
 *
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;

	/**
	 * Retrieves an article by its id.
	 * 
	 * @param id must not be null.
	 * @return the article with the given id or ResponseStatusException if none
	 *         found
	 */
	public Article getArticleById(String id) {
		return repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Article %s not found", id)));
	}

	/**
	 * Retrieves all stored articles sorted by publish date.
	 * 
	 * @return all articles.
	 */
	public List<Article> getArticles() {
		return repository.findAllByOrderByPublishDateDesc();
	}

	/**
	 * Returns a Page of articles meeting the paging restriction provided in the
	 * Pageable object
	 * 
	 * @param page zero-based page index, must not be negative.
	 * @param size the size of the page to be returned, must be greater than 0.
	 * @return a page of articles
	 */
	public Page<Article> getArticles(int page, int size) {
		return repository.findAllByOrderByPublishDateDesc(PageRequest.of(page, size));
	}

	/**
	 * Save a given article. Use the returned instance for further operations as the
	 * save operation might have changed the article instance completely
	 * 
	 * @param article must not be null
	 * @return the saved article; will never be null
	 * @throws IllegalArgumentException - in case the given article is null.
	 */
	public Article create(Article article) {
		return repository.save(article);
	}

	/**
	 * Update a given article. Use the returned instance for further operations as the save operation might have changed the article instance completely
	 * @param id must not be null
	 * @param article must not be null
	 * @return the saved article; will never be null
	 * @throws ResponseStatusException - in case the given id is null
	 */
	public Article update(String id, Article article) {
		Optional<Article> result = repository.findById(id);
		if (result.isPresent()) {
			return repository.save(article);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Article %s is doesn't exists", id));
		}
	}

	/**
	 * Deletes a given article.
	 * @param id must not be null
	 * @throws ResponseStatusException - in case the given id is null
	 */
	public void delete(String id) {
		Optional<Article> result = repository.findById(id);
		if (result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Article %s is doesn't exists", id));
		}
	}

}
