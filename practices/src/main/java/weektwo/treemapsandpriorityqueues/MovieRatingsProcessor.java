package weektwo.treemapsandpriorityqueues;

/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        return Objects.isNull(movieRatings) ? new ArrayList<>() : new ArrayList<>(movieRatings.keySet());
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings,
                                                                int rating) {
        List<String> movies = new ArrayList<>();
        if (Objects.isNull(movieRatings) || movieRatings.isEmpty()) {
            return movies;
        }
        for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
            if (Objects.requireNonNull(entry.getValue().peek()) > rating) {
                movies.add(entry.getKey());
            }
        }
        return movies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings,
                                                                 int rating) {
        int numberOfRatingsRemoved;
        TreeMap<String, Integer> moviesRemoved = new TreeMap<>();
        if (Objects.isNull(movieRatings) || movieRatings.isEmpty()) {
            return moviesRemoved;
        }
        for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
            PriorityQueue<Integer> validRatings = entry.getValue().stream()
                    .filter(v -> v >= rating)
                    .collect(Collectors.toCollection(PriorityQueue::new));
            numberOfRatingsRemoved = entry.getValue().size() - validRatings.size();
            if (numberOfRatingsRemoved != 0) {
                moviesRemoved.put(entry.getKey(), numberOfRatingsRemoved);
                movieRatings.put(entry.getKey(), validRatings);
            }
        }
        removeFieldsWithNoRating(movieRatings);
        return moviesRemoved;
    }

    private static void removeFieldsWithNoRating(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> removeEntries = movieRatings.keySet()
                .stream()
                .filter(rating -> movieRatings.get(rating).isEmpty())
                .collect(Collectors.toList());
        removeEntries.forEach(movieRatings::remove);
    }
}
