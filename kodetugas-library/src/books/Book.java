package books;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty category;
    private final IntegerProperty stock;
    private final IntegerProperty duration;

    public Book(String id, String title, String author, String category, int stock, int duration) {
        this.id = new SimpleStringProperty(id);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.category = new SimpleStringProperty(category);
        this.stock = new SimpleIntegerProperty(stock);
        this.duration = new SimpleIntegerProperty(duration);
    }

    // Getter for id
    public String getId() {
        return id.get();
    }

    // Getter for title
    public String getTitle() {
        return title.get();
    }

    // Getter for author
    public String getAuthor() {
        return author.get();
    }

    // Getter for category
    public String getCategory() {
        return category.get();
    }

    // Getter for stock
    public int getStock() {
        return stock.get();
    }

    // Getter for duration
    public int getDuration() {
        return duration.get();
    }
}
