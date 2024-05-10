class BT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static class BinaryTree {
        int idx = 0;

        public Node buildTree(int nodes[]) {
            if (idx >= nodes.length || nodes[idx] == -1) {
                idx++;
                return null;
            }

            Node newNode = new Node(nodes[idx++]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void display(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            display(root.left);
            display(root.right);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print("Pre-order traversal: ");
        tree.display(root);
    }
}
