import java.util.Scanner;

public class DLL_Reverse<E> {

    public static DLL<Integer> reverseDLL(DLL<Integer> list){
        DLL<Integer> tmp = list;
        tmp.mirror();
        return tmp;
    }

    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }
        System.out.println(reverseDLL(list));
    }
}
