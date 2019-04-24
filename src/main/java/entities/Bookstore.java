package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity //class can be mapped to a table
@NamedQueries({
        @NamedQuery(name = "Bookstore.findAll", query = "select t from Bookstore as t")
})//retrieve all bookstores in the database
@Table(name = "BOOKSTORE")
@Getter @Setter
public class Bookstore {

    public Bookstore(){

    }

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//use special identity columns in the database that generate a value on insertion of a row
    private int id;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "bookstore", fetch = FetchType.EAGER) //load it together with the rest of the fields
    private List<Book> books = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookstore bookstore = (Bookstore) o;

        if (id != bookstore.id) return false;
        if (title != null ? !title.equals(bookstore.title) : bookstore.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

}
