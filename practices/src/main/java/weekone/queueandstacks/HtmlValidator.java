package weekone.queueandstacks;

import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        return getTags(tags); // this line is here only so this code will compile if you don't modify it
    }

    private static Stack<HtmlTag> getTags(Queue<HtmlTag> tags) {
        return noClosingTags(tags) ? putTagsInStack(tags) : areTagsWellFormatted(tags);
    }

    private static Stack<HtmlTag> areTagsWellFormatted(Queue<HtmlTag> tags1) {
        Stack<HtmlTag> tags = new Stack<>();
        for (HtmlTag tag : tags1) {
            if (tag.isOpenTag()) {
                tags.push(tag);
            } else if (!tag.isSelfClosing()) {
                if (tags.isEmpty()) {
                    return null;
                }
                HtmlTag popped = tags.pop();
                if (!popped.matches(tag)) {
                    tags.push(popped);
                    return tags;
                }
            }
        }
        return tags;
    }

    private static boolean noClosingTags(Queue<HtmlTag> tags) {
        return tags.stream().allMatch(tag -> tag.isOpenTag() || tag.isSelfClosing());
    }

    private static Stack<HtmlTag> putTagsInStack(Queue<HtmlTag> tags) {
        return tags.stream().map(tag -> new Stack<HtmlTag>().push(tag)).collect(Collectors.toCollection(Stack::new));
    }
}

