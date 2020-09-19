package weektwo.treemapsandpriorityqueues;

/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> movies = new TreeMap<>();
        if (Objects.nonNull(allUsersRatings)) {
            for (UserMovieRating userMovieRating : allUsersRatings) {
                if (validUserMovieRating(userMovieRating)) {
                    updateMovieMap(movies, userMovieRating);
                }
            }
        }
        return movies;
    }

    private static void updateMovieMap(TreeMap<String, PriorityQueue<Integer>> movies, UserMovieRating movieRating) {
        String mapKey = movieRating.getMovie().toLowerCase();
        if (movies.containsKey(mapKey)) {
            movies.get(mapKey).add(movieRating.getUserRating());
        } else {
            PriorityQueue<Integer> rating = new PriorityQueue<>();
            rating.add(movieRating.getUserRating());
            movies.put(mapKey, rating);
        }
    }

    private static boolean validUserMovieRating(UserMovieRating movieRating) {
        if (Objects.isNull(movieRating)) {
            return false;
        }
        String title = movieRating.getMovie();
        int rating = movieRating.getUserRating();
        return Objects.nonNull(title) && !title.isEmpty() && rating > 0;
    }
}
