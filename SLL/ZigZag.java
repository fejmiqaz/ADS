package Exercises.LinkedLists;

public class ZigZag<E>{
    private SLL<E> list;

    public ZigZag(SLL<E> list) {
        this.list = list;
    }

    public boolean checkZigZag(SLL<E> list) {
        SLLNode<E> current = list.getFirst();
        if(current == null && current.succ == null && current.succ.succ == null){ // checking if there are enough elements for a zigzag check
            return false;
        }

        boolean zigZag = true;
        SLLNode<E> prev = current; // start with the first element
        current = current.succ; // move to the second

        while (current != null) {
            if(prev.element instanceof Integer && current.element instanceof Integer){
                int prevValue = (Integer) prev.element;
                int currentValue = (Integer) current.element;
                // check zigzag condition
                if(zigZag){ // in here prev is smaller than current
                    if(prevValue >= currentValue){
                        return false; // not zigzag
                    }
                }else{ // in here prev is bigger than current
                    if(prevValue <= currentValue){
                        return false; // not zigzag
                    }
                }
            }
            // move to next elements
            prev = current;
            current = current.succ;
            // update the zigzag flag
            zigZag = !zigZag;
        }
        return true; // if it passes the checks, it's a zigzag
    }

    public static void main(String[] args) {
        SLL<Integer> newList = new SLL<Integer>();
        ZigZag<Integer> zigZag = new ZigZag<Integer>(newList);
        newList.insertLast(1);
        newList.insertLast(3);
        newList.insertLast(2);
        newList.insertLast(4);
        newList.insertLast(3);

        boolean n = zigZag.checkZigZag(newList);
        if(n){
            System.out.println("It is zigZag");
        }else{
            System.out.println("It's not zigZag");
        }
    }
}
