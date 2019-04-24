package usecases;

import lombok.Getter;
import lombok.Setter;
import entities.Bookstore;
import persistence.BookstoresDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model //
public class Bookstores {

    @Inject
    private BookstoresDAO bookstoresDAO;

    @Getter @Setter
    private Bookstore bookstoreToCreate = new Bookstore();

    @Getter
    private List<Bookstore> allBookstores;

    @PostConstruct
    public void init(){
        loadAllBookstores();
    }

    @Transactional
    public String createBookstore(){
        this.bookstoresDAO.persist(bookstoreToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllBookstores(){
        this.allBookstores = bookstoresDAO.loadAll();
    }
}
