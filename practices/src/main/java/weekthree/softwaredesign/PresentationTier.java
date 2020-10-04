package weekthree.softwaredesign;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {

    private LogicTier logicTier; // link to the Logic Tier

    public PresentationTier(LogicTier logicTier) {
        this.logicTier = logicTier;
    }

    public void start() {
        /* IMPLEMENT THIS METHOD */
    }

    public void showBookTitlesByAuthor(String author) {
        System.out.println("These are the book titles by author: ");
        this.logicTier.findBookTitlesByAuthor(author).forEach(System.out::println);
    }

    public void showNumberOfBooksInYear(int year) {
        long numberOfPublications = this.logicTier.findNumberOfBooksInYear(year);
        System.out.printf("There are %s books published in year: %s", numberOfPublications, year);
    }
}
