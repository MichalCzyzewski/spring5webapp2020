package pl.mczyzewski.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mczyzewski.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
