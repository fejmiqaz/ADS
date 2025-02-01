import java.util.Scanner;
import java.util.NoSuchElementException;

class FinkiStudent {
    public String name;
    public Integer check1;
    public Integer check2;
    public Integer check3;

    public FinkiStudent(String name, Integer check1, Integer check2, Integer check3) {
        this.name = name;
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
    }
}

public class Queue_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedQueue<FinkiStudent> submit = new LinkedQueue<FinkiStudent>();
        LinkedQueue<FinkiStudent> receiveIndex = new LinkedQueue<FinkiStudent>();
        LinkedQueue<FinkiStudent> requestHighSchoolDocuments = new LinkedQueue<FinkiStudent>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            Integer check1 = sc.nextInt();
            Integer check2 = sc.nextInt();
            Integer check3 = sc.nextInt();
            sc.nextLine();
            FinkiStudent f = new FinkiStudent(name, check1, check2, check3);
            if(f.check1 == 1){
                submit.enqueue(f);
            }else if ( f.check2 == 1){
                receiveIndex.enqueue(f);
            }else if ( f.check3 == 1){
                requestHighSchoolDocuments.enqueue(f);
            }
        }
        while(!submit.isEmpty() || !receiveIndex.isEmpty() || !requestHighSchoolDocuments.isEmpty()) {
            FinkiStudent temp = null;
            if(!submit.isEmpty()){
                temp = submit.dequeue();
                if(temp.check2 == 1){
                    receiveIndex.enqueue(temp);
                }else if (temp.check3 == 1){
                    requestHighSchoolDocuments.enqueue(temp);
                }else{
                    System.out.println(temp.name);
                }
            }
            if(!receiveIndex.isEmpty()){
                temp = receiveIndex.dequeue();
                if(temp.check3 == 1){
                    requestHighSchoolDocuments.enqueue(temp);
                }else{
                    System.out.println(temp.name);
                }
            }
            if(!requestHighSchoolDocuments.isEmpty()){
                temp = requestHighSchoolDocuments.dequeue();
                System.out.println(temp.name);
            }
        }
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}


interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}
