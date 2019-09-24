package pl.michalm.services;

import java.util.List;

import pl.michalm.model.Book;

public interface BookService {

    Book getBookById(final Long id);

    Book findByIsbnNumber(final String isbn);

    List<Book> findByIdGreater(final Long id);

    List<Book> findAllBooks();

    void save(final Book book);
}
