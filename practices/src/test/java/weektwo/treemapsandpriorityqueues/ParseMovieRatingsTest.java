package weektwo.treemapsandpriorityqueues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 
// Decompiled by Procyon v0.5.36
// 

public class ParseMovieRatingsTest {
    List<UserMovieRating> ratings;

    @Before
    public void setUp() {
        this.ratings = new LinkedList<>();
        this.ratings.add(new UserMovieRating("singles", 5));
        this.ratings.add(new UserMovieRating("singles", 4));
        this.ratings.add(new UserMovieRating("zootopia", 4));
        this.ratings.add(new UserMovieRating("zootopia", 2));
    }

    @Test
    public void testNull() {
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings = MovieRatingsParser.parseMovieRatings(null);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings should return empty TreeMap when input is null");
            }
            Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is null",
                    movieRatings.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input is null");
        }
    }

    @Test
    public void testEmpty() {
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(new LinkedList<>());
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings should return empty TreeMap when input is empty");
            }
            Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is empty",
                    movieRatings.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input is empty");
        }
    }

    @Test
    public void testNormalInput() {
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings returns null for valid input List");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", 2L,
                    movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " for valid input List");
        }
    }

    @Test
    public void testIgnoreNullRating() {
        this.ratings.add(null);
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings returns null when input List contains null rating");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating",
                    2L, movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input List contains null rating");
        }
    }

    @Test
    public void testIgnoreNullTitle() {
        this.ratings.add(new UserMovieRating(null, 5));
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with null title");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title",
                    2L, movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input List contains rating with null title");
        }
    }

    @Test
    public void testIgnoreEmptyTitle() {
        this.ratings.add(new UserMovieRating("", 5));
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with empty title");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title",
                    2L, movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input List contains rating with empty title");
        }
    }

    @Test
    public void testIgnoreNegativeRating() {
        this.ratings.add(new UserMovieRating("Singles", -4));
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with negative rating");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating",
                    2L, movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj + " when input List contains rating with negative rating");
        }
    }

    @Test
    public void testIgnoreCase() {
        this.ratings.add(new UserMovieRating("ZOOTOPIA", 3));
        try {
            final TreeMap<String, PriorityQueue<Integer>> movieRatings =
                    MovieRatingsParser.parseMovieRatings(this.ratings);
            if (movieRatings == null) {
                Assert.fail(
                        "parseMovieRatings returns null when input List contains movies with same case-insensitive titles");
            }
            Assert.assertEquals(
                    "TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles",
                    2L, movieRatings.size());
            final PriorityQueue<Integer> priorityQueue = movieRatings.get("singles");
            if (priorityQueue == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles",
                    4L, (int) priorityQueue.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles",
                    5L, (int) priorityQueue.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles",
                    priorityQueue.isEmpty());
            final PriorityQueue<Integer> priorityQueue2 = movieRatings.get("zootopia");
            if (priorityQueue2 == null) {
                Assert.fail(
                        "TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
            }
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles",
                    2L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles",
                    3L, (int) priorityQueue2.remove());
            Assert.assertEquals(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles",
                    4L, (int) priorityQueue2.remove());
            Assert.assertTrue(
                    "PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles",
                    priorityQueue2.isEmpty());
        } catch (Exception obj) {
            Assert.fail("parseMovieRatings throws " + obj +
                    " when input List contains movies with same case-insensitive titles");
        }
    }
}
