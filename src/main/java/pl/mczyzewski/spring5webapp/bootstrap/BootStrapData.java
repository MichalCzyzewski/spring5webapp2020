package pl.mczyzewski.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mczyzewski.spring5webapp.domain.Author;
import pl.mczyzewski.spring5webapp.domain.Book;
import pl.mczyzewski.spring5webapp.domain.Publisher;
import pl.mczyzewski.spring5webapp.repositories.AuthorRepository;
import pl.mczyzewski.spring5webapp.repositories.BookRepository;
import pl.mczyzewski.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher("New Firm Publisher",
                "Super Street 1", "Warsaw", "00-950");
        publisherRepository.save(publisher1);

        Author author1 = new Author("Michal", "Marker");
        Book firstBook1 = new Book("This is it", "31293809843");
        author1.getBooks().add(firstBook1);
        firstBook1.getAuthors().add(author1);


        authorRepository.save(author1);
        bookRepository.save(firstBook1);

        firstBook1.setPublisher(publisher1);
        publisher1.getBooks().add(firstBook1);
        publisherRepository.save(publisher1);


        Author author2 = new Author("Ewa", "Mila");
        Book firstBook2 = new Book("The last day", "8992312123");
        author2.getBooks().add(firstBook2);
        firstBook2.getAuthors().add(author2);


        authorRepository.save(author2);
        bookRepository.save(firstBook2);

        firstBook2.setPublisher(publisher1);
        publisher1.getBooks().add(firstBook2);
        publisherRepository.save(publisher1);


        System.out.println("Loading Authors : " + authorRepository.count() + '\n'
                + "Loading Books : " + bookRepository.count() + '\n'
                + "Publishers Loaded : " + publisherRepository.count());

        System.out.println("Publisher Number of Books : " + publisher1.getBooks().size());
    }
}
