package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher rafzera = new Publisher("Rafzera", "Estrada vila maria","XD","POW","0000-000");
        publisherRepository.save(rafzera);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);

        ddd.getAuthors().add(eric);

        ddd.setPublisher(rafzera);
        rafzera.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(rafzera);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "345345");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(rafzera);
        rafzera.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(rafzera);

        System.out.println("Started Bootstrap");
        System.out.println("number of books " + bookRepository.count());
        System.out.println("number of authors " + authorRepository.count());
        System.out.println("Number of books in publisher " + rafzera.getBooks().size());
        System.out.println("number of publishers " + publisherRepository.count());
    }
}
