package Trees;

import java.util.Scanner;

public class Trees_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<String> tree = new BTree<>();
        BNode<String> rootNode = null;
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n + m; i++) {
            String instruction = sc.next();
            if(instruction.equals("root")){
                String key = sc.next();
                tree.makeRoot(key);
                rootNode = tree.root;
                rootNode.info = key;
            }else if(instruction.equals("add")){
                String parent = sc.next();
                String child = sc.next();
                String where = sc.next();
                BNode<String> finder = find(parent, rootNode);
                if(where.equals("LEFT")){
                    tree.addChild(finder, BNode.LEFT, child);
                }else if(where.equals("RIGHT")){
                    tree.addChild(finder, BNode.RIGHT, child);
                }
            }else if(instruction.equals("ask")){
                String asker = sc.next();
                BNode<String> finder = find(asker, rootNode);
                System.out.println(counter(finder));
            }
        }
        System.out.println(tree.leaves());

    }

    public static int counter(BNode<String> root){
        if(root == null){
            return 0;
        }
        int total = (root.left != null && root.right != null) ? 1 : 0;
        total += counter(root.left);
        total += counter(root.right);
        return total;
    }

    public static BNode<String> find(String find, BNode<String> node){
        if(node == null){
            return null;
        }

        if(node.info.equals(find)){
            return node;
        }

        BNode<String> parent = find(find, node.left);
        if(parent != null){
            return parent;
        }
        return find(find, node.right);

    }
}
