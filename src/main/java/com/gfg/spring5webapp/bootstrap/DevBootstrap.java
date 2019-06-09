package com.gfg.spring5webapp.bootstrap;

import com.gfg.spring5webapp.model.Author;
import com.gfg.spring5webapp.model.Book;
import com.gfg.spring5webapp.model.Publisher;
import com.gfg.spring5webapp.repository.AuthorRepository;
import com.gfg.spring5webapp.repository.BookRepository;
import com.gfg.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric","Evans");
        Publisher dddPub = new Publisher("O'reilly","New York");
        Book ddd = new Book("Domain Driven Design","1224",dddPub);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(dddPub);
        bookRepository.save(ddd);




        Author rod = new Author("Rod","Johnson");
        Publisher noEJBPub = new Publisher("Safari","Delhi");
        Book noEJB = new Book("J2EE dev without EJB","2345",noEJBPub);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(noEJBPub);
        bookRepository.save(noEJB);


    }
}
