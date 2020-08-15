package az.maqa.spring.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.maqa.spring.dto.BookDTO;
import az.maqa.spring.entity.Book;
import az.maqa.spring.exception.BookNotFoundException;
import az.maqa.spring.repository.BookRepository;
import az.maqa.spring.request.RequestBook;
import az.maqa.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookDTO> getAllBooks() {
		ModelMapper modelMapper = new ModelMapper();

		Iterable<Book> books = bookRepository.findAll();

		Type listType = new TypeToken<List<BookDTO>>() {
		}.getType();

		List<BookDTO> returnValue = modelMapper.map(books, listType);

		return returnValue;
	}

	@Override
	public BookDTO getBookById(Long id) {
		ModelMapper modelMapper = new ModelMapper();

		Book book = bookRepository.getBookById(id);

		if (book == null)
			throw new BookNotFoundException("Book not found for this id: " + id);

		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

		return bookDTO;
	}

	@Override
	public BookDTO addBook(RequestBook requestBook) {
		ModelMapper modelMapper = new ModelMapper();

		Book book = modelMapper.map(requestBook, Book.class);

		Book savedBook = bookRepository.save(book);

		BookDTO returnValue = modelMapper.map(savedBook, BookDTO.class);

		return returnValue;
	}

}
