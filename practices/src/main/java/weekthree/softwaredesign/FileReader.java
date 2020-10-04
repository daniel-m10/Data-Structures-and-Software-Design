package weekthree.softwaredesign;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements IReader {
    private static final String TAB = "\t";

    @Override
    public List<Book> getAllBooks(String file) {
        List<Book> books = new ArrayList<>();
        try {
            Path filePath = Paths.get(file);
            for (String line : Files.readAllLines(filePath)) {
                String[] details = line.split(TAB);
                books.add(new Book(details[0], details[1], Integer.parseInt(details[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
