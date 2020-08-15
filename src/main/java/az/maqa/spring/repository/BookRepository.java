package az.maqa.spring.repository;

import org.springframework.data.repository.CrudRepository;

import az.maqa.spring.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	Book getBookById(Long id);
	
}
