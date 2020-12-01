package org.a.demo.repositories;

import java.util.List;

import org.a.demo.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

	/**
	 * Retrieves all stored articles sorted by publish date.
	 * @return all articles
	 */
	public List<Article> findAllByOrderByPublishDateDesc();
	
	/**
	 * Returns a Page of articles meeting the paging restriction provided in the
	 * Pageable object
	 * 
	 * @param pageable
	 * @return a page of articles
	 */
	public Page<Article> findAllByOrderByPublishDateDesc(Pageable pageable);
	
}
