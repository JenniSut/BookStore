package fi.syksy2021.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

	public interface BookRepository extends CrudRepository <Book, Long> {
		
		
	};

