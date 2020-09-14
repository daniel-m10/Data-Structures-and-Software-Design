package weekone.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        List<Sentence> sentences = new LinkedList<>();
        List<String> lines = readFileAsListOfStrings(filename);
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                addSentenceToCollection(sentences, line, i);
            }
        }
        return sentences;
    }

    /*
     * Implement this method in Part 2
     */

    public static Set<Word> allWords(List<Sentence> sentences) {
        Set<Word> words = new HashSet<>();
        if (Objects.nonNull(sentences) && !sentences.isEmpty()) {
            for (Sentence sentence : sentences) {
                addWordsToCollection(words, sentence);
            }
        }
        return words;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        Map<String, Double> scores = new HashMap<>();
        if (Objects.nonNull(words) && !words.isEmpty()) {
            Set<Word> validWords = words.stream().filter(Objects::nonNull).collect(Collectors.toSet());
            for (Word word : validWords) {
                scores.put(word.getText(), word.calculateScore());
            }
        }
        return scores;
    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double total = 0.0;
        if (Objects.nonNull(wordScores) && Objects.nonNull(sentence) && !sentence.isEmpty()) {
            List<String> validWords = getValidWords(sentence);
            if (!validWords.isEmpty()) {
                total = getTotalScore(wordScores, total, validWords);
                return total / validWords.size();
            }
        }
        return total;
    }

    private static double getTotalScore(Map<String, Double> wordScores, double total, List<String> validWords) {
        for (String word : validWords) {
            if (!wordScores.containsKey(word)) {
                wordScores.put(word, 0.0);
            }
            total += wordScores.get(word);
        }
        return total;
    }

    private static List<String> getValidWords(String sentence) {
        return Arrays.stream(sentence.toLowerCase()
                .split(" "))
                .filter(Analyzer::isAValidWord)
                .collect(Collectors.toList());
    }

    private static boolean isAValidWord(String word) {
        return Character.isLetter(word.charAt(0));
    }

    private static boolean isAnAllowedScore(String score) {
        return !score.contains(".") && Integer.parseInt(score) >= -2 && Integer.parseInt(score) <= 2;
    }

    private static boolean isAScore(String line, int index) {
        return Character.isSpaceChar(line.charAt(index)) && Character.isDigit(line.charAt(index - 1));
    }

    private static List<String> readFileAsListOfStrings(String filename) {
        try {
            Path path = Paths.get(filename);
            return Files.readAllLines(path);
        } catch (IOException | NullPointerException e) {
            return new LinkedList<>();
        }
    }

    private static void addWordsToCollection(Set<Word> words, Sentence sentence) {
        if (!Objects.isNull(sentence)) {
            Word word = null;
            String stringWord = sentence.getText().toLowerCase();
            for (String singleWord : stringWord.split(" ")) {
                if (isAValidWord(singleWord)) {
                    word = new Word(singleWord);
                }
                if (Objects.nonNull(word) && !words.add(word)) {
                    updateSetOfWords(words, sentence, word);
                }
            }
        }
    }

    private static void updateSetOfWords(Set<Word> words, Sentence sentence, Word word) {
        int total = word.getTotal() + sentence.getScore();
        word.increaseTotal(total);
        words.remove(word);
        words.add(word);
    }

    private static void addSentenceToCollection(List<Sentence> sentences, String line, int i) {
        int score;
        if (isAScore(line, i)) {
            String stringScore = line.substring(0, i);
            String sentence = line.substring(i).trim();
            if (isAnAllowedScore(stringScore) && !sentence.equals("")) {
                score = Integer.parseInt(line.substring(0, i));
                sentences.add(new Sentence(score, sentence.trim()));
            }
        }
    }
}
