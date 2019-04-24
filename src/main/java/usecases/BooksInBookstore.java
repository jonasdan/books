package usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import entities.Bookstore;
import entities.Book;
import persistence.BooksDAO;
import persistence.BookstoresDAO;

@Model //model layer
public class BooksInBookstore implements Serializable{

    @Inject
    private BookstoresDAO bookstoresDAO;

    @Inject
    private BooksDAO booksDAO;

    @Getter @Setter
    private Bookstore bookstore;

    @Getter @Setter
    private Book bookToCreate = new Book();

    @PostConstruct //method that needs to be executed after dependency injection is done to perform any initialization
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int bookstoreId = Integer.parseInt(requestParameters.get("bookstoreId"));
        this.bookstore = bookstoresDAO.findOne(bookstoreId);
    }

    @Transactional
    public String createBook(){
        bookToCreate.setBookstore(this.bookstore);
        booksDAO.persist(bookToCreate);
        return "books?faces-redirect=true&bookstoreId=" + this.bookstore.getId();
    }
}
