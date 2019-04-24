package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity //class can be mapped to a table
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select a from Book as a")
})//retrieve all books in the database
@Table(name = "BOOK")
@Getter @Setter
public class Book implements Serializable {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//use special identity columns in the database that generate a value on insertion of a row
    private int id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name="BOOKSTORE_ID")
    private Bookstore bookstore;

    @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")})
    @ManyToMany //many to many with authors
    private List<Author> authors = new ArrayList<>();

    public Book(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
