package tel_ran.books.interfaces;

import tel_ran.books.entity.Author;
import tel_ran.books.entity.Book;
import tel_ran.books.entity.Publisher;

public interface IBooks {
	boolean addBook(Book book);
	boolean removeBook(long isbn);
	Book getBookByISBN(long isbn);
	Iterable<Book> getBooksByAuthor(String authorName);
	Iterable<Book> getBooksByPublisher(String publisherName);
	Iterable<Author> getBookAuthors(long isbn);
	Iterable<Publisher> getPublishersByAuthor(String authorName);
}
