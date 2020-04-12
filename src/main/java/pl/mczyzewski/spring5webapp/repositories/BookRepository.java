package pl.mczyzewski.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mczyzewski.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
