package az.maqa.spring.service;

import java.util.List;

import az.maqa.spring.dto.BookDTO;
import az.maqa.spring.request.RequestBook;

public interface BookService {

	List<BookDTO> getAllBooks();

	BookDTO getBookById(Long id);

	BookDTO addBook(RequestBook requestBook);

	
}
