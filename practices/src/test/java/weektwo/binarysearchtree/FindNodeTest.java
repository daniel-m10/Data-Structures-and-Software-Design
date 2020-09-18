package weektwo.binarysearchtree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// 
// Decompiled by Procyon v0.5.36
// 

public class FindNodeTest {
    protected BinarySearchTree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<>();
        this.tree.add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }

    @Test
    public void testTargetIsRoot() {
        try {
            final BinarySearchTree<String>.Node node = this.tree.findNode("dog");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is root", "dog",
                    node.value);
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is root");
        }
    }

    @Test
    public void testTargetIsLeftChildOfRoot() {
        try {
            final BinarySearchTree<String>.Node node = this.tree.findNode("cat");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is left child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is left child of root",
                    "cat", node.value);
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is left child of root");
        }
    }

    @Test
    public void testTargetIsRightChildOfRoot() {
        try {
            final BinarySearchTree<String>.Node node = this.tree.findNode("pig");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is right child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is right child of root",
                    "pig", node.value);
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is right child of root");
        }
    }

    @Test
    public void testTargetIsGrandchildOfRoot() {
        this.tree.add("ant");
        try {
            final BinarySearchTree<String>.Node node = this.tree.findNode("ant");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is grandchild of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is grandchild of root",
                    "ant", node.value);
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is grandchild of root");
        }
    }

    @Test
    public void testTargetIsNotInTree() {
        try {
            Assert.assertNull("findNode did not return null when looking for value that is not in tree",
                    this.tree.findNode("monkey"));
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is not in tree");
        }
    }

    @Test
    public void testTargetIsNull() {
        try {
            Assert.assertNull("findNode did not return null when input value is null", this.tree.findNode(null));
        } catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when input value is null");
        }
    }
}
