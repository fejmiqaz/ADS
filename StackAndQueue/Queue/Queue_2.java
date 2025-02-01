import java.util.Scanner;
import java.util.NoSuchElementException;

class Student {
    public String name;
    public int check1;
    public int check2;
    public int check3;

    public Student(String name, int check1, int check2, int check3) {
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
        LinkedQueue<Student> science = new LinkedQueue<Student>();
        LinkedQueue<Student> scienceFiction = new LinkedQueue<Student>();
        LinkedQueue<Student> history = new LinkedQueue<Student>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int check1 = sc.nextInt();
            int check2 = sc.nextInt();
            int check3 = sc.nextInt();
            sc.nextLine();
            Student s = new Student(name, check1, check2, check3);
            if(s.check1 == 1){
                science.enqueue(s);
            }else if (s.check2 == 1){
                scienceFiction.enqueue(s);
            }else if (s.check3 == 1){
                history.enqueue(s);
            }
        }
        while(!science.isEmpty() || !scienceFiction.isEmpty() || !history.isEmpty()){
            int m = 2;
            Student temp = null;
            while(!science.isEmpty() && m > 0){
                temp = science.dequeue();
                if(temp.check2 == 1){
                    scienceFiction.enqueue(temp);
                }else if (temp.check3 == 1){
                    history.enqueue(temp);
                }else{
                    System.out.println(temp.name);
                }
                m--;
            }
            m = 1;
            while(!scienceFiction.isEmpty() && m > 0){
                temp = scienceFiction.dequeue();
                if(temp.check3 == 1){
                    history.enqueue(temp);
                }else{
                    System.out.println(temp.name);
                }
                m--;            }
            m = 2;
            while(!history.isEmpty() && m > 0){
                temp = history.dequeue();
                System.out.println(temp.name);
                m--;
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


