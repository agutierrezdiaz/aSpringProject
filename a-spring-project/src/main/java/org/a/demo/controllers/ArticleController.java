package org.a.demo.controllers;

import org.a.demo.entities.Article;
import org.a.demo.services.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for content management of article
 * @author Adrian Gutierrez
 *
 */
@RestController
@RequestMapping("/admin/articles")
public class ArticleController {

	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService service;

	@GetMapping
	public ResponseEntity<Page<Article>> getArticleList(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "8") int size) {
		return new ResponseEntity<Page<Article>>(service.getArticles(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") String id) {
		return new ResponseEntity<Article>(service.getArticleById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		return new ResponseEntity<Article>(service.create(article), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable("id") String id, @RequestBody Article article) {
		return new ResponseEntity<Article>(service.update(id, article), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Article> deleteArticle(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
