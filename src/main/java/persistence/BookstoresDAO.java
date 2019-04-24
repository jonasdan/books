package persistence;

import entities.Book;
import entities.Bookstore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BookstoresDAO {

    @PersistenceContext//handling a set of entities
    private EntityManager em;


    public List<Bookstore> loadAll() {
        return em.createNamedQuery("Bookstore.findAll", Bookstore.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Bookstore bookstore){
        this.em.persist(bookstore);
    }

    public Bookstore findOne(Integer id) {
        return em.find(Bookstore.class, id);
    }

}
