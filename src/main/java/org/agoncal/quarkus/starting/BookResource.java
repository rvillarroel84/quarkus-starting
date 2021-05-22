package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Undestanding Quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Practising Quarkus", "Antonio", 2020, "IT"),
                new Book(3, "Effective Java", "Josh Blosh", 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, "IT"));
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }

}