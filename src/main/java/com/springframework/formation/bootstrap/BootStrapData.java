package com.springframework.formation.bootstrap;

import com.springframework.formation.domain.Book;
import com.springframework.formation.domain.Author;
import com.springframework.formation.domain.Publisher;
import com.springframework.formation.repositories.AuthorRepository;
import com.springframework.formation.repositories.BookRepository;
import com.springframework.formation.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        System.out.println("Started In Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("OnePublish");
        publisher.setCity("Paris");
        publisher.setState("IdF");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count:" + publisherRepository.count());

        Author simon = new Author("Simon", "Saliba");
        Book ddd = new Book("Domain Driven Design", "123123");
        simon.getBooks().add(ddd);
        ddd.getAuthors().add(simon);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(simon);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "45554637");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
