package persistence;

import entities.Author;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AuthorsDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(Author author){
        this.em.persist(author);
    }

}
