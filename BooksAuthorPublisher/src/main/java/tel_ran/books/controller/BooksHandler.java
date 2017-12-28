package tel_ran.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tel_ran.books.entity.Author;
import tel_ran.books.entity.Book;
import tel_ran.books.entity.Publisher;
import tel_ran.books.interfaces.IBookConstants;
import tel_ran.books.interfaces.IBooks;

@RestController
public class BooksHandler {
	
	@Autowired
	IBooks books;
	
	@PostMapping(IBookConstants.BOOK)
	public boolean addBook(@RequestBody Book book) {
		return books.addBook(book);
	}

	@GetMapping({IBookConstants.BOOK+"/{isbn}"})
	public Book getBook(@PathVariable long isbn) {
		return books.getBookByISBN(isbn);
	}
	
	@GetMapping({IBookConstants.AUTHOR+"/{authorName}"})
	public Iterable<Book> getBooksByAuthor(@PathVariable String authorName){
		return books.getBooksByAuthor(authorName);
	}
	
	@GetMapping({IBookConstants.PUBLISHER+"/{publisherName}"})
	public Iterable<Book> getBooksByPublisher(@PathVariable String publisherName) {
		return books.getBooksByPublisher(publisherName);
	}
	
	@DeleteMapping({IBookConstants.BOOK+"/{isbn}"})
	public boolean removeBook(@PathVariable long isbn) {
		return books.removeBook(isbn);
	}
	
	@GetMapping({IBookConstants.AUTHORS+"/{isbn}"})
	public Iterable<Author> getBookAuthors(@PathVariable long isbn) {
		return books.getBookAuthors(isbn);
	}
	
	@GetMapping({IBookConstants.PUBLISHERS+"/{authorName}"})
	public Iterable<Publisher> getPublishersByAuthor(@PathVariable String authorName) {
		return books.getPublishersByAuthor(authorName);
	}
}
