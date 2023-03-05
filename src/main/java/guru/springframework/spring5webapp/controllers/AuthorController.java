package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepo;

@Controller
public class AuthorController {

	private AuthorRepo authorRepo;

	public AuthorController(AuthorRepo authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}
	@RequestMapping("/authors")
	public String getAuthhors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/list";
	}
}
