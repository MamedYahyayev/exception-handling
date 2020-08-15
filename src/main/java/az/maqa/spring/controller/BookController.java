package az.maqa.spring.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.spring.dto.BookDTO;
import az.maqa.spring.request.RequestBook;
import az.maqa.spring.response.ResponseBook;
import az.maqa.spring.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<ResponseBook> getAllBooks() {
		ModelMapper modelMapper = new ModelMapper();

		Type listType = new TypeToken<List<ResponseBook>>() {
		}.getType();

		List<BookDTO> books = bookService.getAllBooks();

		List<ResponseBook> response = modelMapper.map(books, listType);

		return response;
	}

	@GetMapping(value = "/{id}")
	public ResponseBook getBookById(@PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();

		BookDTO books = bookService.getBookById(id);

		ResponseBook response = modelMapper.map(books, ResponseBook.class);

		return response;
	}

	
	@PostMapping
	public ResponseBook addBook(@Valid @RequestBody RequestBook requestBook) {
		ModelMapper modelMapper = new ModelMapper();

		BookDTO book = bookService.addBook(requestBook);

		ResponseBook response = modelMapper.map(book, ResponseBook.class);

		return response;
	}

}
