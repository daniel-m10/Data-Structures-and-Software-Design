package weekthree.softwaredesign;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.List;
import java.util.stream.Collectors;

public class LogicTier {

    private DataTier dataTier; // link to the Data Tier

    public LogicTier(DataTier dataTier) {
        this.dataTier = dataTier;
    }

    public List<String> findBookTitlesByAuthor(String authorName) {
        return this.dataTier.getAllBooks()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public long findNumberOfBooksInYear(int year) {
        return this.dataTier.getAllBooks()
                .stream()
                .filter(book -> book.getPublicationYear() == year)
                .count();
    }
}
