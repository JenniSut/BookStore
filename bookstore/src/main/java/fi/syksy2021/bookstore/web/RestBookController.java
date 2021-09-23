package fi.syksy2021.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.syksy2021.bookstore.domain.BookRepository;
import fi.syksy2021.bookstore.domain.CategoryRepository;
import fi.syksy2021.bookstore.domain.Book;


@RestController 
public class RestBookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrepository;
	
	//Getting all books
	@RequestMapping(value="/books" , method = RequestMethod.GET)
			public @ResponseBody List<Book> bookListRest() {
			return (List<Book>) repository.findAll();
			}
	//Adding a book
	@RequestMapping(value="/books" , method = RequestMethod.POST)
		public List<Book> saveBook(@RequestBody Book book){
		repository.save(book);
		return (List<Book>) repository.findAll();
	}
	
};
