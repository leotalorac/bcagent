import java.util.Arrays;
import java.util.Scanner;

public class mainloop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bcagend bca = new bcagend();
        System.out.println(bca.actualnum);
        while (true){
            String p =  sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            String ans = bca.calculate(p,a,b);
            System.out.println(ans);
        }
    }
}
