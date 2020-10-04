package weekthree.softwaredesign;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.List;

public class DataTier {
    private String fileName; // the name of the file to read
    private IReader reader;

    public DataTier(String inputSource) {
        fileName = inputSource;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public List<Book> getAllBooks() {
        return this.reader.getAllBooks(this.fileName);
    }
}
