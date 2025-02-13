package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepo;

@Controller
public class BookController {
	
	private BookRepo bookRepo;
	

	public BookController(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books/list";
	}
}
