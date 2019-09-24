package pl.michalm.dao;

import static pl.michalm.dao.QueryHolder.ID_GREATER_THAN_QUERY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.michalm.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(final String isbn);

    @Query(value = ID_GREATER_THAN_QUERY)
    List<Book> findAllByIdIsGreaterThan(Long ids);

}