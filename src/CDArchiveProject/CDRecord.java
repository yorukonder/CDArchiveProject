package CDArchiveProject;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CDRecord {
//    int index;
    String title;
    String author;
    int x;
    int y;
    int barcode;
    String description;
    String section;
    boolean onLoan;

    public  CDRecord(int barcode) {
        this.barcode = barcode;
    }
    public int getBarcode() {
        return barcode;
    }

    public CDRecord(String title, String author, String section,
                    int x, int y, int barcode, String description, boolean onLoan){

//        this.index = index;
        this.title = title;
        this.author = author;
        this.section = section;
        this.x = x;
        this.y = y;
        this.barcode = barcode;
        this.description = description;
        this.onLoan = onLoan;

    }

//    public int getIndex() {
//        return index;
//    }
//    public void setIndex(int index) {
//        this.index = index;
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
//    public int getBarcode() {
//        return barcode;
//
//    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @Override
    public String toString() {
        return "CDRecord{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", barcode=" + barcode +
                ", description='" + description + '\'' +
                ", section='" + section + '\'' +
                ", onLoan=" + onLoan +
                '}';
    }
}
