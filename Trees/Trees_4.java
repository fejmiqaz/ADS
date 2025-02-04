package Trees;

/* In the following task you need to build a BT with N nodes, for whcih you will need to answer Q questions of the type:
what is the average depth of the nodes in the subtree of a selected node. We will consider the depth of the roots of the subtrees to be 1.
Hint: average is calculated as the sum divided by the number of members in the sum. You can use two functions.
Each node will have a unique index from 1 to N. The root of the tree will alwasy have an index 1. All children will have indices greater
than the parent indices.
 */

import java.util.Objects;
import java.util.Scanner;

public class Trees_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        BTree<Integer> tree = new BTree<>();
        BNode<Integer> rootNode = null;
        for (int i = 0; i < n + m; i++) {
            String instruction = sc.next();
            if(instruction.equals("root")) {
                Integer first = sc.nextInt();
                tree.makeRoot(first);
                rootNode = tree.root;
            } else if(instruction.equals("add")) {
                Integer parent = sc.nextInt();
                Integer child = sc.nextInt();
                String where = sc.next();
                BNode<Integer> parentNode = find(parent, rootNode);
                if (where.equals("LEFT")) {
                    tree.addChild(parentNode, BNode.LEFT, child);
                } else if (where.equals("RIGHT")) {
                    tree.addChild(parentNode, BNode.RIGHT, child);
                }
            }else if(instruction.equals("ask")) {
                    Integer idx = sc.nextInt();
                    BNode<Integer> finder = find(idx, rootNode);
                    double averageDepth = avg(finder,1)[0] / avg(finder,1)[1];
                    System.out.println((int)averageDepth);
            }
        }
    }

    public static double[] avg(BNode<Integer> root, int depth) {
        if(root == null){
            return new double[]{0, 0};
        }
        double[] left = avg(root.left, depth + 1);
        double[] right = avg(root.right, depth + 1);

        double sum = depth + left[0] + right[0];
        double nodeCNT = 1 + left[1] + right[1];

        return new double[]{sum, nodeCNT};

    }

    public static BNode<Integer> find(Integer finder, BNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (Objects.equals(root.info, finder)) {
            return root;
        }

        BNode<Integer> current = find(finder, root.left);
        if (current != null) {
            return current;
        }
        return find(finder, root.right);
    }

}
