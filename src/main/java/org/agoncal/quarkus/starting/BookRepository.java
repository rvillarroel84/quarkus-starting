package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Undestanding Quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Practising Quarkus", "Antonio", 2020, "IT"),
                new Book(3, "Effective Java", "Josh Blosh", 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, "IT"));
    }

    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }

}