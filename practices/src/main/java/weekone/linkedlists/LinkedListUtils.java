package weekone.linkedlists;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (Objects.nonNull(list)) {
            list.add(value);
            Collections.sort(list);
        }
    }

    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (Objects.nonNull(list) && !list.isEmpty() && N > 0) {
            for (int i = 1; i < list.size(); i++) {
                String firstElement = list.getFirst();
                String currentElement = list.get(i);
                if (currentElement.compareTo(firstElement) > 0) {
                    list.remove(currentElement);
                    list.addFirst(currentElement);
                }
            }
            for (int i = 0; i < N; i++) {
                String currentElement = list.getFirst();
                for (int j = 0; j < list.size(); j++) {
                    list.remove(currentElement);
                }
                if (list.size() < N) {
                    break;
                }
            }
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (Objects.nonNull(one) && Objects.nonNull(two) && !one.isEmpty() && !two.isEmpty()) {
            for (int i = 0; i < two.size(); i++) {
                if (two.getFirst().equals(one.get(i))) {
                    int index = one.indexOf(two.getFirst());
                    for (Integer integer : two) {
                        if (!integer.equals(one.get(index++))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
