package usecases;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.BookstoreMapper;
import mybatis.model.Bookstore;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model //model layer
public class BookstoresMyBatis {

    @Inject
    private BookstoreMapper bookstoreMapper;

    @Getter
    private List<Bookstore> allBookstores;

    @Getter @Setter
    private Bookstore bookstoreToCreate = new Bookstore();

    @PostConstruct
    public void init() {
        this.loadAllBookstores();
    }

    private void loadAllBookstores() {
        this.allBookstores = bookstoreMapper.selectAll();
    }

    @Transactional
    public String createBookstore() {
        bookstoreMapper.insert(bookstoreToCreate);
        return "/myBatis/bookstores?faces-redirect=true";
    }

}
