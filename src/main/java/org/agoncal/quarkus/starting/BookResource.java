package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository repository;
    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        logger.info("Return all Books");
        return repository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Return number of Books");
        return repository.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Return a single Book by id " + id);
        return repository.getBook(id);
    }

}