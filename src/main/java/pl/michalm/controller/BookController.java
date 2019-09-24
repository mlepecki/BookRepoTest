package pl.michalm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.michalm.model.Book;
import pl.michalm.services.BookService;

@RestController("/")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(path = "/book/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping(path = "/book")
    public Book findBookByIsbn(@RequestParam String isbn){
        return bookService.findByIsbnNumber(isbn);
    }

    @GetMapping(path = "/book/idgreater/{id}")
    public List<Book> findBookByIdGreater(@PathVariable Long id){
        return bookService.findByIdGreater(id);
    }

    @PostMapping(path = "/book/create")
    public void createBook(@RequestBody Book book){
        bookService.save(book);
    }

}
