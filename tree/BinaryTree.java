import java.util.*;

class BinaryTree {
    // Lớp Node cho cây nhị phân
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Thêm node vào cây (cho ví dụ, thêm đơn giản)
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    // BFS: Duyệt cây theo mức (level-order traversal)
    public void BFS() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    // DFS: Duyệt cây theo ba kiểu
    // 1. Pre-order: Root -> Left -> Right
    public void DFSPreOrder() {
        System.out.print("Pre-order: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // 2. In-order: Left -> Root -> Right
    public void DFSInOrder() {
        System.out.print("In-order: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // 3. Post-order: Left -> Right -> Root
    public void DFSPostOrder() {
        System.out.print("Post-order: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main để test
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Thêm các node vào cây
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Breadth-First Search (Level-order):");
        tree.BFS();
        System.out.println("\n");

        System.out.println("Depth-First Search:");
        tree.DFSPreOrder();
        tree.DFSInOrder();
        tree.DFSPostOrder();
    }
}