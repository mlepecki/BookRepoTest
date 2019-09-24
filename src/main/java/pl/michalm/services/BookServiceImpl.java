package pl.michalm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michalm.dao.BookRepository;
import pl.michalm.exception.BookNotFoundException;
import pl.michalm.model.Book;

@Service
public class BookServiceImpl implements BookService {

    private static final String MESSAGE = "There is no any books in repo!";

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(final Long id) {
        final Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book findByIsbnNumber(final String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(()->new BookNotFoundException("There is no book with isbn: " + isbn));
    }

    @Override
    public List<Book> findAllBooks() {
        final List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new BookNotFoundException(MESSAGE);
        } else {
            return books;
        }
    }

    @Override
    public void save(final Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByIdGreater(final Long id){
       return bookRepository.findAllByIdIsGreaterThan(id);
    }
}
