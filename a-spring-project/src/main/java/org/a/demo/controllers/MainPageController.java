package org.a.demo.controllers;

import java.util.List;

import org.a.demo.entities.Article;
import org.a.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for main page
 * @author Adrian Gutierrez
 *
 */
@RestController
@RequestMapping("/")
public class MainPageController {

	@Autowired
	private ArticleService service;

	@GetMapping
	public ResponseEntity<List<Article>> getHome() {
		return new ResponseEntity<List<Article>>(service.getArticles(), HttpStatus.OK);
	}
	
}
