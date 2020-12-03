package org.a.demo.controllers;

import org.a.demo.entities.Article;
import org.a.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class for main page
 * 
 * @author Adrian Gutierrez
 *
 */
@Controller
public class DefaultController {

	@Autowired
	private ArticleService service;

	@GetMapping("/")
	public String getHome(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "6") int size) {
		Page<Article> articles = service.getArticles(page, size);
		model.addAttribute("title", "aSpring Project");
		model.addAttribute("contentList", articles);
		return "main";
	}

	@GetMapping("/article/{id}")
	public String getArticleDetail(Model model, @PathVariable("id") String id) {
		Article article = service.getArticleById(id);
		model.addAttribute("article", article);
		return "article";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	@GetMapping("/404")
	public String error404() {
		return "/error/404";
	}

}
