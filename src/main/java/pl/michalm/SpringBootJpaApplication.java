package pl.michalm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.michalm.model.Book;
import pl.michalm.services.BookService;

@SpringBootApplication
@EnableWebMvc
public class SpringBootJpaApplication {

    @Autowired
    public BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            //            Utworzenie testowych ksiazek
            final Book book = new Book("12345", "Pan Tadek1", "Adam Mickiewicz");
            final Book book2 = new Book("112345", "Pan Tadek2", "Adam Mickiewicz2");
            final Book book3 = new Book("212345", "Pan Tadek3", "Adam Mickiewicz3");
            final Book book4 = new Book("312345", "Pan Tadek4", "Adam Mickiewicz4");

            //            Zapisanie ksiazek do bazy
            bookService.save(book);
            bookService.save(book2);
            bookService.save(book3);
            bookService.save(book4);
        };
    }
}