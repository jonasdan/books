package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity //class can be mapped to a table
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "select b from Author as b")
}) //retrieve all authors in the database
@Table(name = "AUTHOR")
@Getter @Setter
public class Author implements Serializable{

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//use special identity columns in the database that generate a value on insertion of a row
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "authors") //bidirectional many to many with books
    private List<Book> books = new ArrayList<>();

    public Author(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
