package fi.syksy2021.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.syksy2021.bookstore.domain.Book;
import fi.syksy2021.bookstore.domain.BookRepository;
import fi.syksy2021.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrepository;
	
	
	//@RequestMapping(value="/index")
	
	@GetMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return("booklist");
		
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return("addbook");
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return("redirect:booklist");
		
	}
	
	@GetMapping ("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
		}
	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", catrepository.findAll());
		return "editbook";
	}
}
