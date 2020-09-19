package weektwo.binarysearchtree;


import java.util.Objects;

public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        E value;
        Node leftChild = null;
        Node rightChild = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj instanceof BinarySearchTree.Node) == false) {
                return false;
            }
            @SuppressWarnings("unchecked")
            Node other = (BinarySearchTree<E>.Node) obj;
            return other.value.compareTo(value) == 0 &&
                    other.leftChild == leftChild && other.rightChild == rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    protected Node root = null;

    protected void visit(Node n) {
        System.out.println(n.value);
    }

    public boolean contains(E val) {
        return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
        if (n == null) {
            return false;
        }

        if (n.value.equals(val)) {
            return true;
        } else if (n.value.compareTo(val) > 0) {
            return contains(n.leftChild, val);
        } else {
            return contains(n.rightChild, val);
        }
    }

    public boolean add(E val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    protected boolean add(Node n, E val) {
        if (n == null) {
            return false;
        }
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return false; // this ensures that the same value does not appear more than once
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    public boolean remove(E val) {
        return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
        if (n == null) {
            return false;
        }

        if (val.compareTo(n.value) == -1) {
            return remove(n.leftChild, n, val);
        } else if (val.compareTo(n.value) == 1) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent == null) {
                root = n.leftChild != null ? n.leftChild : n.rightChild;
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected E maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }


    /*********************************************
     *
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    // Method #1.
    public Node findNode(E val) {
        return Objects.isNull(val) ? null : findNode(root, val);
    }

    private Node findNode(Node n, E value) {
        if (n == null) {
            return null;
        }
        if (n.value.equals(value)) {
            return n;
        } else if (value.compareTo(n.value) > 0) {
            return findNode(n.rightChild, value);
        } else {
            return findNode(n.leftChild, value);
        }
    }

    // Method #2.
    protected int depth(E val) {
        int counter = 0;
        return Objects.isNull(val) ? -1 : depth(root, val, counter);
    }

    private int depth(Node n, E value, int counter) {
        if (Objects.isNull(findNode(n, value))) {
            return -1;
        }
        if (n.value.equals(value)) {
            return counter;
        } else if (value.compareTo(n.value) > 0) {
            counter++;
            return depth(n.rightChild, value, counter);
        } else {
            counter++;
            return depth(n.leftChild, value, counter);
        }
    }

    // Method #3.
    protected int height(E val) {
        if (Objects.isNull(val)) {
            return -1;
        }
        Node node = findNode(root, val);
        int counter = 0;
        return Objects.isNull(node) ? -1 : Math.max(leftHeight(node, counter), rightHeight(node, counter));
    }

    private int leftHeight(Node node, int heightCounter) {
        if (Objects.isNull(node.leftChild)) {
            return heightCounter;
        } else {
            heightCounter++;
            return leftHeight(node.leftChild, heightCounter);
        }
    }

    private int rightHeight(Node node, int heightCounter) {
        if (Objects.isNull(node.rightChild)) {
            return heightCounter;
        } else {
            heightCounter++;
            return rightHeight(node.rightChild, heightCounter);
        }
    }

    // Method #4.
    protected boolean isBalanced(Node n) {
        if (Objects.isNull(n) || !contains(n.value)) {
            return false;
        }
        int counter = 0;
        int leftHeight = leftHeight(n, counter);
        int rightHeight = rightHeight(n, counter);
        int heightsDifference = Math.abs(leftHeight - rightHeight);
        return heightsDifference == 0 || heightsDifference == 1;
    }

    // Method #5. .
    public boolean isBalanced() {
        return isLeftNodesBalanced(root, true) && isRightNodesBalanced(root, true);
    }

    private boolean isLeftNodesBalanced(Node node, boolean balanced) {
        if (Objects.isNull(node) || !balanced) {
            return balanced;
        } else {
            balanced = isBalanced(node);
            return isLeftNodesBalanced(node.leftChild, balanced);
        }
    }

    private boolean isRightNodesBalanced(Node node, boolean balanced) {
        if (Objects.isNull(node) || !balanced) {
            return balanced;
        } else {
            balanced = isBalanced(node);
            return isRightNodesBalanced(node.rightChild, balanced);
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
