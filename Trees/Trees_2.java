package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trees_2 {
    public static void main(String[] args) {
        BTree<String> tree = new BTree<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        BNode<String> rootNode = null;
        BNode<String> parentNode = null;
        for(int i = 0; i < n + m; i++) {
            String instruction = sc.next();
            if(instruction.equals("root")){
                String key = sc.next();
                tree.makeRoot(key);
                rootNode = tree.root;
            }else if(instruction.equals("add")){
                String parent = sc.next();
                String child = sc.next();
                String where = sc.next();
                parentNode = find(parent, rootNode);
                if(where.equals("LEFT")){
                    tree.addChild(parentNode, BNode.LEFT,child);
                }else if(where.equals("RIGHT")){
                    tree.addChild(parentNode, BNode.RIGHT,child);
                }
            }else if(instruction.equals("ask")){
                String fromWhere = sc.next();
                BNode<String> randomNode = find(fromWhere, rootNode);
                System.out.println(counter(randomNode));
            }
        }
    }
    public static int counter(BNode<String> node){
        if(node == null){
            return 0;
        }
        int total = (node.left != null || node.right != null) ? 1 : 0;
        total += counter(node.left);
        total += counter(node.right);
        return total;
    }
    public static BNode<String> find(String parent, BNode<String> root){
        if(root == null){
            return null;
        }
        if(root.info.equals(parent)){
            return root;
        }
        BNode<String> foundNode = find(parent, root.left);
        if(foundNode != null){
            return foundNode;
        }
        return find(parent, root.right);
    }
}
