package weektwo.binarysearchtree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// 
// Decompiled by Procyon v0.5.36
// 

public class IsBalancedNodeTest {
    protected BinarySearchTree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<>();
        this.tree.add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }

    @Test
    public void testNull() {
        try {
            Assert.assertFalse("isBalanced should be false when input value is null", this.tree.isBalanced(null));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when input value is null");
        }
    }

    @Test
    public void testNotInTreeDifferentValue() {
        final BinarySearchTree<String>.Node node = new BinarySearchTree<String>().new Node("banana");
        try {
            Assert.assertFalse("isBalanced should be false when input Node is not in tree", this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when input Node is not in tree");
        }
    }

    @Test
    public void testRootBalanced() {
        final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
        try {
            Assert.assertTrue("isBalanced should be true when input Node is root of tree with two children",
                    this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when input Node is root of tree with two children");
        }
    }

    @Test
    public void testLeaf() {
        final BinarySearchTree<String>.Node node = this.tree.findNode("cat");
        try {
            Assert.assertTrue("isBalanced should be true when input Node is leaf", this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when input Node is leaf");
        }
    }

    @Test
    public void testLeftHeightIsOneGreaterThanRight() {
        this.tree.add("ant");
        final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
        try {
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1",
                    this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testRightHeightIsOneGreaterThanLeft() {
        this.tree.add("zebra");
        final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
        try {
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1",
                    this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testLeftHeightIsTwoGreaterThanRight() {
        this.tree.add("ant");
        this.tree.add("aah!");
        final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
        try {
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1",
                    this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of child nodes is more than 1");
        }
    }

    @Test
    public void testRightHeightIsTwoGreaterThanLeft() {
        this.tree.add("rat");
        this.tree.add("skunk");
        final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
        try {
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1",
                    this.tree.isBalanced(node));
        } catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of child nodes is more than 1");
        }
    }
}
