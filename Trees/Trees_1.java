package Trees;

import Hashing.SLLNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trees_1 {
    public static void main(String[] args) {
        SLLTree<Integer> tree = new SLLTree<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, SLLTree.SLLNode<Integer>> nodes = new HashMap<>();

        SLLTree.SLLNode<Integer> rootNode = null;
        SLLTree.SLLNode<Integer> parentNode = null;
        SLLTree.SLLNode<Integer> childNode = null;
        for (int i = 0; i < n + m; i++) {
            String instruction = sc.next();
            if(instruction.equals("root")){
                int root = sc.nextInt();
                tree.makeRoot(root);
                rootNode = (SLLTree.SLLNode<Integer>) tree.root();
                nodes.put(root, rootNode);
            }else if(instruction.equals("add")){
                int parent = sc.nextInt();
                int child = sc.nextInt();
                parentNode = nodes.get(parent);
                childNode = (SLLTree.SLLNode<Integer>) tree.addChild(parentNode, child);
                nodes.put(child, childNode);
            }else if(instruction.equals("ask")){
                int idx = sc.nextInt();
                SLLTree.SLLNode<Integer> node = nodes.get(idx);
                System.out.println(countLeaves(node));
            }
        }
    }
    private static int countLeaves(SLLTree.SLLNode<Integer> node) {
        if(node.firstChild == null){
            return 1;
        }
        int total = 0;
        SLLTree.SLLNode<Integer> cur = node.firstChild;
        while(cur != null){
            total += countLeaves(cur);
            cur = cur.sibling;
        }
        return total;
    }
}
