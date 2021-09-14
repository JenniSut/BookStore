package fi.syksy2021.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.syksy2021.bookstore.domain.Book;
import fi.syksy2021.bookstore.domain.BookRepository;
import fi.syksy2021.bookstore.domain.Category;
import fi.syksy2021.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catrepository) {
		return (args) -> {
			catrepository.save(new Category("Fantasy"));
			catrepository.save(new Category("War"));
			catrepository.save(new Category("Satire"));
			
			
			
			System.out.println("adding a few books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1232323-21", 1929, 29, catrepository.findByName("War").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", "2212343-5", 1945, 30, catrepository.findByName("Satire").get(0)));

			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	};

}
