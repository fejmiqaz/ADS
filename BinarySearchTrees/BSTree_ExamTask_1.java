package SearchTrees;

import java.util.Scanner;

public class BSTree_ExamTask_1 {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer val = sc.nextInt();
            tree.insert(val);
        }
        BNode<Integer> head = tree.getRoot();
        traversal(head);
    }
    public static void traversal(BNode<Integer> node){
        if(node!=null){
            traversal(node.left);
            System.out.println(node.info);
            traversal(node.right);
        }
    }
}
