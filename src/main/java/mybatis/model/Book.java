package mybatis.model;

public class Book {

    private int id;

    private String title;

    private int bookstoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(int bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

}
