
import java.util.Scanner;

public class Main {
    public static BNode<String> find(BNode<String> node, String val){
        return findN(node, val);
    }

    private static BNode<String> findN(BNode<String> node, String val){
        if(node == null){
            return null;
        }

        if(node.info.equals(val)){
            return node;
        }

        BNode<String> result1 = findN(node.left, val);
        BNode<String> result2 = findN(node.right, val);
        if(result1!=null){
            return result1;
        }
        if(result2!=null){
            return result2;
        }

        return null;
    }


    public static int count(BNode<String> node){
        if(node == null){
            return 0;
        }


        int number = 1;

        number += count(node.left);
        number += count(node.right);


        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        BTree<String> tree = new BTree<>();
        for (int i = 0; i < n + q; i++) {
            String instruction = sc.next();
            if(instruction.equals("root")){
                String root = sc.next();
                tree.makeRoot(root);
            }else if(instruction.equals("add")){
                String a = sc.next(), b = sc.next();
                String where = sc.next();
                BNode<String> node = find(tree.root, a);
                if(where.equals("LEFT")){
                    tree.addChild(node, BNode.LEFT, b);
                }else if(where.equals("RIGHT")){
                    tree.addChild(node, BNode.RIGHT, b);
                }
            }else if(instruction.equals("ask")){
                BNode<String> node = find(tree.root,sc.next());
                System.out.println(count(node)-1);
            }
        }
    }
}
