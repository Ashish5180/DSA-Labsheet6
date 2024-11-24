class AVLTree {
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    Node root;

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data)
            return rotateRight(node);
        if (balance < -1 && data > node.right.data)
            return rotateLeft(node);
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
}
