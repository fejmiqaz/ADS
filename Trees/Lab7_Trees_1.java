package Labs.Trees;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Lab7_Trees_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();

        SLLTree<Integer> tree = new SLLTree<>();
        Map<Integer, SLLTree.SLLNode<Integer>> nodes = new HashMap<>();

        for(int i = 0; i < n +q; i++){
            String s = sc.nextLine();
            String [] parts = s.split(" ");

            if(parts[0].equals("root")){
                tree.makeRoot(Integer.parseInt(parts[1]));
                SLLTree.SLLNode<Integer> rootNode = (SLLTree.SLLNode<Integer>) tree.root();
                nodes.put(Integer.parseInt(parts[1]), rootNode);
            }else if(parts[0].equals("add")){
                SLLTree.SLLNode<Integer> parentNode = nodes.get(Integer.parseInt(parts[1]));
                SLLTree.SLLNode<Integer> childNode = (SLLTree.SLLNode<Integer>) tree.addChild(parentNode, Integer.parseInt(parts[2]));
                nodes.put(Integer.parseInt(parts[2]), childNode);
            }else if(parts[0].equals("ask")){
                SLLTree.SLLNode<Integer> node = nodes.get(Integer.parseInt(parts[1]));
                System.out.println(leavesCount(node));
            }
        }
    }
    private static int leavesCount(SLLTree.SLLNode<Integer> node){
        if(node == null){
            return 0;
        }
        int total = 0;
        Stack<SLLTree.SLLNode<Integer>> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            SLLTree.SLLNode<Integer> curr = stack.pop();
            if(curr.firstChild == null){
                total++;
            }else{
                SLLTree.SLLNode<Integer> child = curr.firstChild;
                while(child != null){
                    stack.push(child);
                    child = child.sibling;
                }
            }
        }
        return total;
    }
}
