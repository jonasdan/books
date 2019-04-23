package persistence;

import entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BooksDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(Book book){
        this.em.persist(book);
    }

}
